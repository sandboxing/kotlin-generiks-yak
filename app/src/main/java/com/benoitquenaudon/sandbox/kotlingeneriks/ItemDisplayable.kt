package com.benoitquenaudon.sandbox.kotlingeneriks

interface ItemDisplayable {
  fun isSameAs(newItem: ItemDisplayable): Boolean
}
