package com.example.codepathmail

import java.util.Date

class EmailItem(
    private var name: String? = null,
    private var subject: String? = null,
    private var message: String? = null,
    private var opened: Boolean = false,
    var date: Date? = null
) {
    // getter and setter for 'name' property
    var senderName: String?
        get() = name
        set(value) {
            name = value
        }

    // getter and setter for 'subject' property
    var subjectLine: String?
        get() = subject
        set(value) {
            subject = value
        }

    // getter and setter for 'message' property
    var emailMessage: String?
        get() = message
        set(value) {
            message = value
        }

    // getter and setter for opened email
    var hasOpened: Boolean?
        get() = opened
        set(value) {
            if (value != null) {
                opened = value
            }
        }
}
