package com.c.a.b;

public enum k {
    UNREACHABLE(0, "unreachable object"),
    INVALID_TYPE(1, "invalid type"),
    INTERNED_STRING(2, "interned string"),
    UNKNOWN(3, "unknown"),
    SYSTEM_CLASS(4, "system class"),
    VM_INTERNAL(5, "vm internal"),
    DEBUGGER(6, "debugger"),
    NATIVE_LOCAL(7, "native local"),
    NATIVE_STATIC(8, "native static"),
    THREAD_BLOCK(9, "thread block"),
    BUSY_MONITOR(10, "busy monitor"),
    NATIVE_MONITOR(11, "native monitor"),
    REFERENCE_CLEANUP(12, "reference cleanup"),
    FINALIZING(13, "finalizing"),
    JAVA_LOCAL(14, "java local"),
    NATIVE_STACK(15, "native stack"),
    JAVA_STATIC(16, "java static");
    
    public final String mName;
    private final int mType;

    private k(int i2, String str) {
        this.mType = i2;
        this.mName = str;
    }
}
