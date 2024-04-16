package miu.mdp.assignment6.sport.data

abstract class Repository<T> {
    protected open lateinit var data: MutableList<T>
    fun get(): List<T> = data
    fun add(item: T) = data.add(item)
}
