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

package com.github.ontio.core.scripts

enum class ScriptOp {
    // Constants
    OP_PUSH0(0x00), // An empty array of bytes is pushed onto the stack. (This is not a no-op: an item is added to the stack.)
    OP_PUSHF(OP_PUSH0),
    OP_PUSHBYTES1(0x01), // 0x01-0x4B The next opcode bytes is data to be pushed onto the stack
    OP_PUSHBYTES75(0x4B),
    OP_PUSHDATA1(0x4C), // The next byte contains the number of bytes to be pushed onto the stack.
    OP_PUSHDATA2(0x4D), // The next two bytes contain the number of bytes to be pushed onto the stack.
    OP_PUSHDATA4(0x4E), // The next four bytes contain the number of bytes to be pushed onto the stack.
    OP_PUSHM1(0x4F), // The number -1 is pushed onto the stack.
    //OP_RESERVED(0x50), // Transaction is invalid unless occuring in an unexecuted OP_IF branch
    OP_PUSH1(0x51), // The number 1 is pushed onto the stack.
    OP_PUSHT(OP_PUSH1),
    OP_PUSH2(0x52), // The number 2 is pushed onto the stack.
    OP_PUSH3(0x53), // The number 3 is pushed onto the stack.
    OP_PUSH4(0x54), // The number 4 is pushed onto the stack.
    OP_PUSH5(0x55), // The number 5 is pushed onto the stack.
    OP_PUSH6(0x56), // The number 6 is pushed onto the stack.
    OP_PUSH7(0x57), // The number 7 is pushed onto the stack.
    OP_PUSH8(0x58), // The number 8 is pushed onto the stack.
    OP_PUSH9(0x59), // The number 9 is pushed onto the stack.
    OP_PUSH10(0x5A), // The number 10 is pushed onto the stack.
    OP_PUSH11(0x5B), // The number 11 is pushed onto the stack.
    OP_PUSH12(0x5C), // The number 12 is pushed onto the stack.
    OP_PUSH13(0x5D), // The number 13 is pushed onto the stack.
    OP_PUSH14(0x5E), // The number 14 is pushed onto the stack.
    OP_PUSH15(0x5F), // The number 15 is pushed onto the stack.
    OP_PUSH16(0x60), // The number 16 is pushed onto the stack.


    // Flow control
    OP_NOP(0x61), // Does nothing.
    OP_JMP(0x62),
    OP_JMPIF(0x63),
    OP_JMPIFNOT(0x64),
    OP_CALL(0x65),
    OP_RET(0x66),
    OP_APPCALL(0x67),
    OP_SYSCALL(0x68),
    OP_VERIFY(0x69), // Marks transaction as invalid if top stack value is not true. True is removed, but false is not.
    OP_DUPFROMALTSTACK(0x6A), // Marks transaction as invalid.


    // Stack
    OP_TOALTSTACK(0x6B), // Puts the input onto the top of the alt stack. Removes it from the main stack.
    OP_FROMALTSTACK(0x6C), // Puts the input onto the top of the main stack. Removes it from the alt stack.
    OP_XDROP(0x6D), // Removes the top two stack items.
    OP_2DUP(0x6E), // Duplicates the top two stack items.
    OP_3DUP(0x6F), // Duplicates the top three stack items.
    OP_2OVER(0x70), // Copies the pair of items two spaces back in the stack to the front.
    OP_2ROT(0x71), // The fifth and sixth items back are moved to the top of the stack.
    OP_XSWAP(0x72), // Swaps the top two pairs of items.
    OP_XTUCK(0x73), // If the top stack value is not 0, duplicate it.
    OP_DEPTH(0x74), // Puts the number of stack items onto the stack.
    OP_DROP(0x75), // Removes the top stack item.
    OP_DUP(0x76), // Duplicates the top stack item.
    OP_NIP(0x77), // Removes the second-to-top stack item.
    OP_OVER(0x78), // Copies the second-to-top stack item to the top.
    OP_PICK(0x79), // The item n back in the stack is copied to the top.
    OP_ROLL(0x7A), // The item n back in the stack is moved to the top.
    OP_ROT(0x7B), // The top three items on the stack are rotated to the left.
    OP_SWAP(0x7C), // The top two items on the stack are swapped.
    OP_TUCK(0x7D), // The item at the top of the stack is copied and inserted before the second-to-top item.


    // Splice
    OP_CAT(0x7E), // Concatenates two strings.
    OP_SUBSTR(0x7F), // Returns a section of a string.
    OP_LEFT(0x80), // Keeps only characters left of the specified point in a string.
    OP_RIGHT(0x81), // Keeps only characters right of the specified point in a string.
    OP_SIZE(0x82), // Returns the length of the input string.


    // Bitwise logic
    OP_INVERT(0x83), // Flips all of the bits in the input.
    OP_AND(0x84), // Boolean and between each bit in the inputs.
    OP_OR(0x85), // Boolean or between each bit in the inputs.
    OP_XOR(0x86), // Boolean exclusive or between each bit in the inputs.
    OP_EQUAL(0x87), // Returns 1 if the inputs are exactly equal, 0 otherwise.
    //OP_EQUALVERIFY(0x88), // Same as OP_EQUAL, but runs OP_VERIFY afterward.
    //OP_RESERVED1(0x89), // Transaction is invalid unless occuring in an unexecuted OP_IF branch
    //OP_RESERVED2(0x8A), // Transaction is invalid unless occuring in an unexecuted OP_IF branch

    // Arithmetic
    // Note: Arithmetic inputs are limited to signed 32-bit integers, but may overflow their output.
    OP_INC(0x8B), // 1 is added to the input.
    OP_DEC(0x8C), // 1 is subtracted from the input.
    OP_SIGN(0x8D), // The input is multiplied by 2.
    //OP_2DIV(0x8E), // The input is divided by 2.
    OP_NEGATE(0x8F), // The sign of the input is flipped.
    OP_ABS(0x90), // The input is made positive.
    OP_NOT(0x91), // If the input is 0 or 1, it is flipped. Otherwise the output will be 0.
    OP_NZ(0x92), // Returns 0 if the input is 0. 1 otherwise.
    OP_ADD(0x93), // a is added to b.
    OP_SUB(0x94), // b is subtracted from a.
    OP_MUL(0x95), // a is multiplied by b.
    OP_DIV(0x96), // a is divided by b.
    OP_MOD(0x97), // Returns the remainder after dividing a by b.
    OP_SHL(0x98), // Shifts a left b bits, preserving sign.
    OP_SHR(0x99), // Shifts a right b bits, preserving sign.
    OP_BOOLAND(0x9A), // If both a and b are not 0, the output is 1. Otherwise 0.
    OP_BOOLOR(0x9B), // If a or b is not 0, the output is 1. Otherwise 0.
    OP_NUMEQUAL(0x9C), // Returns 1 if the numbers are equal, 0 otherwise.
    //OP_NUMEQUALVERIFY(0x9D), // Same as OP_NUMEQUAL, but runs OP_VERIFY afterward.
    OP_NUMNOTEQUAL(0x9E), // Returns 1 if the numbers are not equal, 0 otherwise.
    OP_LT(0x9F), // Returns 1 if a is less than b, 0 otherwise.
    OP_GT(0xA0), // Returns 1 if a is greater than b, 0 otherwise.
    OP_LTE(0xA1), // Returns 1 if a is less than or equal to b, 0 otherwise.
    OP_GTE(0xA2), // Returns 1 if a is greater than or equal to b, 0 otherwise.
    OP_MIN(0xA3), // Returns the smaller of a and b.
    OP_MAX(0xA4), // Returns the larger of a and b.
    OP_WITHIN(0xA5), // Returns 1 if x is within the specified range (left-inclusive), 0 otherwise.


    // Crypto
    OP_RIPEMD160(0xA6), // The input is hashed using RIPEMD-160.
    OP_SHA1(0xA7), // The input is hashed using SHA-1.
    OP_SHA256(0xA8), // The input is hashed using SHA-256.
    OP_HASH160(0xA9), // The input is hashed twice: first with SHA-256 and then with RIPEMD-160.
    OP_HASH256(0xAA), // The input is hashed two times with SHA-256.
    //OP_CODESEPARATOR(0xAB), // All of the signature checking words will only match signatures to the data after the most recently-executed OP_CODESEPARATOR.
    OP_CHECKSIG(0xAC), // The entire transaction's outputs, inputs, and script (from the most recently-executed OP_CODESEPARATOR to the end) are hashed. The signature used by OP_CHECKSIG must be a valid signature for this hash and public key. If it is, 1 is returned, 0 otherwise.
    //OP_CHECKSIGVERIFY(0xAD), // Same as OP_CHECKSIG, but OP_VERIFY is executed afterward.
    OP_CHECKMULTISIG(0xAE), // For each signature and public key pair, OP_CHECKSIG is executed. If more public keys than signatures are listed, some key/sig pairs can fail. All signatures need to match a public key. If all signatures are valid, 1 is returned, 0 otherwise. Due to a bug, one extra unused value is removed from the stack.
    //OP_CHECKMULTISIGVERIFY(0xAF), // Same as OP_CHECKMULTISIG, but OP_VERIFY is executed afterward.


    // Array
    OP_ARRAYSIZE(0xC0),
    OP_PACK(0xC1),
    OP_UNPACK(0xC2),
    OP_PICKITEM(0xC3),
    OP_SETITEM(0xC4),
    OP_NEWARRAY(0xC5),
    OP_NEWSTRUCT(0xC6),
    OP_NEWMAP(0xC7),
    OP_APPEND(0xC8),
    OP_REVERSE(0xC9),
    OP_REMOVE(0xCA),
    OP_HASKEY(0xCB),
    OP_KEYS(0xCC),
    OP_VALUES(0xCD),
    OP_ANY(0xCE),
    OP_SUM(0xCF),
    OP_AVERAGE(0xD0),
    OP_MAXITEM(0xD1),
    OP_MINITEM(0xD2),

    OP_THROW(0xF0),
    OP_THROWIFNOT(0xF1);

    val byte: Byte

    constructor(v: Int) {
        byte = v.toByte()
    }

    constructor(v: ScriptOp) {
        byte = v.byte
    }

    companion object {
        fun valueOf(v: Int): ScriptOp? {
            for (op in ScriptOp.values()) {
                if (op.byte == v.toByte()) {
                    return op
                }
            }
            return null
        }
    }
}