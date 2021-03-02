package com.tencent.thumbplayer.a.b.b;

import com.tencent.thumbplayer.api.TPCommonEnum;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class a {

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* renamed from: com.tencent.thumbplayer.a.b.b.a$a  reason: collision with other inner class name */
    public @interface AbstractC2202a {
        @TPCommonEnum.NativeConnectionAction
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        @TPCommonEnum.NativeConnectionConfig
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        @TPCommonEnum.NativeErrorType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
        @TPCommonEnum.OptionalIdType
        int type();

        @TPCommonEnum.NativeInitConfig
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
        @TPCommonEnum.NativeMsgInfo
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface f {
        @TPCommonEnum.OptionalIdType
        int type();

        @TPCommonEnum.NativeOptionalId
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface g {
        @TPCommonEnum.NativePropertyId
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface h {
        @TPCommonEnum.NativeSeekMode
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface i {
        @TPCommonEnum.NativeSwitchDefMode
        int value();
    }
}
