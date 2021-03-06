/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.redis.connection.lettuce;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.resource.ClientResources;

import java.time.Duration;
import java.util.Optional;

/**
 * Default implementation of {@literal LettuceClientConfiguration}.
 *
 * @author Mark Paluch
 * @since 2.0
 */
class DefaultLettuceClientConfiguration implements LettuceClientConfiguration {

	private final boolean useSsl;
	private final boolean verifyPeer;
	private final boolean startTls;
	private final Optional<ClientResources> clientResources;
	private final Optional<ClientOptions> clientOptions;
	private final Duration timeout;
	private final Duration shutdownTimeout;

	DefaultLettuceClientConfiguration(boolean useSsl, boolean verifyPeer, boolean startTls,
			ClientResources clientResources, ClientOptions clientOptions, Duration timeout, Duration shutdownTimeout) {

		this.useSsl = useSsl;
		this.verifyPeer = verifyPeer;
		this.startTls = startTls;
		this.clientResources = Optional.ofNullable(clientResources);
		this.clientOptions = Optional.ofNullable(clientOptions);
		this.timeout = timeout;
		this.shutdownTimeout = shutdownTimeout;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration#useSsl()
	 */
	@Override
	public boolean isUseSsl() {
		return useSsl;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration#isVerifyPeer()
	 */
	@Override
	public boolean isVerifyPeer() {
		return verifyPeer;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration#isStartTls()
	 */
	@Override
	public boolean isStartTls() {
		return startTls;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration#getClientResources()
	 */
	@Override
	public Optional<ClientResources> getClientResources() {
		return clientResources;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration#getClientOptions()
	 */
	@Override
	public Optional<ClientOptions> getClientOptions() {
		return clientOptions;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration#getTimeout()
	 */
	@Override
	public Duration getCommandTimeout() {
		return timeout;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration#getShutdownTimeout()
	 */
	@Override
	public Duration getShutdownTimeout() {
		return shutdownTimeout;
	}
}
