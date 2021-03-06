package com.kurume_nct.studybattle.model

/**
 * Created by gedorinku on 2017/10/15.
 */
abstract class Item(val id: Int)

object Air : Item(0)

object Bomb : Item(1)

object Shield : Item(2)

object DoubleScoreCard : Item(3)

object MagicHand : Item(4)

data class ItemStack(val id: Int, val count: Int)