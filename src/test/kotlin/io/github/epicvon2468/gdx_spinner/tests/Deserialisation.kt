package io.github.epicvon2468.gdx_spinner.tests

import Yarn.YarnSpinner
import Yarn.operand

import kotlin.test.Test
import kotlin.test.assertEquals

class Deserialisation {

	@Test
	fun deserialise() {
		val program: YarnSpinner.Program = YarnSpinner.Program.parseFrom(
			this::class.java.getResourceAsStream("/scripts/out/TryYarnSpinner/TryYarnSpinner.yarnc")
		)
		assertEquals(
			operand {
				floatValue = 0.0f
			},
			program.initialValuesMap[$$"$gold"]!!
		)
	}
}