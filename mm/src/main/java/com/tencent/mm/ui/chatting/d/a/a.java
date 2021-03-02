package com.tencent.mm.ui.chatting.d.a;

import com.tencent.mm.ui.chatting.d.af;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface a {

    /* renamed from: com.tencent.mm.ui.chatting.d.a.a$a  reason: collision with other inner class name */
    public static class C2091a implements af {
    }

    Class<? extends af> gRF() default C2091a.class;
}
