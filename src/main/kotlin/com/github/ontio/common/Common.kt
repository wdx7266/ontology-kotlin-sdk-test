/*
 * Copyright (C) 2018 The ontology Authors
 * This file is part of The ontology library.
 *
 *  The ontology is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  The ontology is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with The ontology.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.github.ontio.common

import com.github.ontio.crypto.ECC
import java.text.SimpleDateFormat
import java.util.*

abstract class Common : AutoCloseable {
    companion object {
        var didont = "did:ont:"
        val MULTI_SIG_MAX_PUBKEY_SIZE = 16
        val TX_MAX_SIG_SIZE = 16

        fun generateKey64Bit(): ByteArray {
            return ECC.generateKey(64)
        }

        fun currentTime(): String {
            return SimpleDateFormat("yyyyMMddHHmmss").format(Date())
        }

        private fun now(): String {
            return SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Date())
        }
    }

}
