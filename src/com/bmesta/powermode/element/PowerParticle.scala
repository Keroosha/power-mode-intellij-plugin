/*
 * Copyright 2015 Baptiste Mesta
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bmesta.powermode.element

import java.awt._

import com.bmesta.powermode.PowerColor
import org.jetbrains.annotations.NotNull

/**
  * @author Baptiste Mesta
  */
case class PowerParticle(var x: Float, var y: Float, dx: Float, var dy: Float, size: Float, val initLife: Long, color: PowerColor) extends ElementOfPower {
  val life = System.currentTimeMillis() + initLife

  def update: Boolean = {
    dy = dy + 0.075f
    x += dx
    y += dy
    !alive
  }

  def render(@NotNull g: Graphics, dxx: Int, dyy: Int) {
    if (alive) {
      val g2d: Graphics2D = g.create.asInstanceOf[Graphics2D]
      g2d.setColor(new Color(color._1, color._2, color._3, color._4))
      g2d.fillOval((dxx + x - (size / 2)).toInt, (dyy + y - (size / 2)).toInt, size.toInt, size.toInt)
      g2d.dispose()
    }
  }

}