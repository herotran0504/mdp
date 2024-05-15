package miu.mdp.assignment7.animal.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface BaseDao<in T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(items: List<T>): List<Long>

    @Update
    suspend fun update(item: T): Int

    @Update
    suspend fun update(items: List<T>): Int

    @Delete
    suspend fun delete(item: T): Int

}

@Transaction
suspend fun <T> BaseDao<T>.updateOrInsert(item: T): Long {
    val insertResult = insert(item)
    return if (insertResult == -1L) {
        update(item).toLong()
    } else insertResult
}

@Transaction
suspend fun <T> BaseDao<T>.updateOrInsert(items: List<T>) {
    val insertResults = insert(items)
    val updates = insertResults.indices
        .filter { insertResults[it] == -1L }
        .map { items[it] }
    if (updates.isNotEmpty()) {
        update(updates)
    }
}
