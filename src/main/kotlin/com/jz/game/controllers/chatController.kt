package com.jz.game.controllers

import com.jz.game.dtos.MessageDTO
import com.pusher.rest.Pusher
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class chatController {
    @PostMapping("/messages")
    fun message(@RequestBody body: MessageDTO):ResponseEntity<Any>{
        val pusher = Pusher("1710789", "7859273f462c60e52c0e", "14dcb377bca1f07d5d6d")
        pusher.setCluster("eu")
        pusher.setEncrypted(true)

        pusher.trigger("chat-app", "message", body)

        return ResponseEntity.ok(emptyArray<String>())
    }
}