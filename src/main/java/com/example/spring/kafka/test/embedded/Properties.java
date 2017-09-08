package com.example.spring.kafka.test.embedded;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "demo", ignoreUnknownFields = false)
public class Properties {

  /**
   * List of bootstrap servers
   */
  private String bootstrapServers;

  public void setBootstrapServers(String bootstrapServers) {
    this.bootstrapServers = bootstrapServers;
  }

  public String getBootstrapServers() {
    return bootstrapServers;
  }
  
}
