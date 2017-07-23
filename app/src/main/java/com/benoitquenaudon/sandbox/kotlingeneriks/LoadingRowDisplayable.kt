package com.benoitquenaudon.sandbox.kotlingeneriks

object LoadingRowDisplayable : ItemDisplayable {
  override fun isSameAs(newItem: ItemDisplayable): Boolean {
    return newItem is LoadingRowDisplayable
  }
}
