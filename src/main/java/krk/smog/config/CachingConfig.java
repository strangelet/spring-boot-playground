package krk.smog.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.Arrays;

/**
 * Enabling cache for REST calls.
 */
@Configuration
@EnableCaching
public class CachingConfig extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
                new ConcurrentMapCache("airly_now"),
                new ConcurrentMapCache("history")));
        return cacheManager;
    }

    /**
     * Flushing REST cache each 30 seconds.
     */
    @CacheEvict(allEntries = true, cacheNames = { "airly_now", "history" })
    @Scheduled(fixedDelay = 30000)
    public void reportCacheEvict() {
    }
}

