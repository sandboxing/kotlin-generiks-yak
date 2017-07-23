package com.benoitquenaudon.sandbox.kotlingeneriks

data class RowDisplayable private constructor(
    val dummy: String
) : ItemDisplayable {
  override fun isSameAs(newItem: ItemDisplayable): Boolean {
    return newItem is RowDisplayable
  }
}
