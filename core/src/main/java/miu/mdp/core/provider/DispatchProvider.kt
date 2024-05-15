package miu.mdp.core.provider

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface DispatchProvider {
    fun io(): CoroutineDispatcher

    fun ui(): CoroutineDispatcher
}

internal class DispatchProvidersImpl @Inject constructor() : DispatchProvider {
    override fun io() = Dispatchers.IO

    override fun ui() = Dispatchers.Main
}