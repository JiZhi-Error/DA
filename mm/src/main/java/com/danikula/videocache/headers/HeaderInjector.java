package com.danikula.videocache.headers;

import java.util.Map;

public interface HeaderInjector {
    Map<String, String> addHeaders(String str);
}
