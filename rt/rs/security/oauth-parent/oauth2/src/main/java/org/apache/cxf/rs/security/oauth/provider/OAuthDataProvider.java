/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.cxf.rs.security.oauth.provider;

import org.apache.cxf.rs.security.oauth.common.Client;
import org.apache.cxf.rs.security.oauth.common.ServerAccessToken;

/**
 * OAuth provider responsible for persisting the information about 
 * OAuth consumers, request and access tokens.
 */
public interface OAuthDataProvider {

    /**
     * Returns the previously registered third-party {@link Client} 
     * @param clientId the client id
     * @return Client
     * @throws OAuthServiceException
     */
    Client getClient(String clientId) throws OAuthServiceException;

    /**
     * Create access token 
     * @param accessToken the token registration info 
     * @return AccessToken
     * @throws OAuthServiceException
     */
    void persistAccessToken(ServerAccessToken accessToken) throws OAuthServiceException;
    
    /**
     * Get access token 
     * @param accessToken the token key 
     * @return AccessToken
     * @throws OAuthServiceException
     */
    ServerAccessToken getAccessToken(String accessToken) throws OAuthServiceException;
    
    /**
     * Refresh access token 
     * @param clientId the client id
     * @param refreshToken the token key 
     * @return AccessToken
     * @throws OAuthServiceException
     */
    ServerAccessToken refreshAccessToken(String clientId, String refreshToken) throws OAuthServiceException;

    /**
     * Removes the token
     * @param token the token
     * @throws OAuthServiceException
     */
    void removeAccessToken(ServerAccessToken accessToken) throws OAuthServiceException;
    
}
