package com.nikik0.userProcessing.services

import com.nikik0.userProcessing.dtos.CurrentUserInfo
import kotlinx.coroutines.flow.toList
import org.springframework.http.HttpHeaders
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlow

@Service
class ExternalSecurityService {

    private val baseurl = "http://localhost:8080/api/v1/auth/info"

    private val securityProvider = WebClient.builder().baseUrl(baseurl).build()

    suspend fun callToCheckCred(authentication: String, acceptedRoles: List<String>): Boolean {
        val currentUserInfo =
            securityProvider.get().header(HttpHeaders.AUTHORIZATION, authentication).retrieve().bodyToFlow<CurrentUserInfo>()
                .toList().first()
        return acceptedRoles.contains(currentUserInfo.role.lowercase())
    }

}