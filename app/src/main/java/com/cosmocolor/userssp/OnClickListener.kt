package com.cosmocolor.userssp

import com.cosmocolor.userssp.models.User

interface OnClickListener {
    fun onClick(user: User, position: Int)
}