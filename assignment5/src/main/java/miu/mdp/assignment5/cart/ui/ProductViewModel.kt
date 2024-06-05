package miu.mdp.assignment5.cart.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import miu.mdp.assignment5.cart.data.ProductRepository
import miu.mdp.assignment5.cart.model.Product
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> get() = _products

    private val _message = MutableSharedFlow<String>()
    val message: SharedFlow<String> get() = _message.asSharedFlow()

    private val cart = mutableListOf<Product>()

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            _products.value = productRepository.getProducts()
        }
    }

    fun addToCart(product: Product) {
        cart.add(product)
        showMessage("Added ${product.productName} to cart")
    }

    fun viewCart() {
        if (cart.isEmpty()) {
            showMessage("Cart is empty")
        } else {
            showMessage(cart.joinToString("\n") { it.productName })
        }
    }

    private fun showMessage(message: String) {
        viewModelScope.launch {
            _message.emit(message)
        }
    }

    fun findProduct(productId: String) = _products.value.find { it.productId == productId }
}
