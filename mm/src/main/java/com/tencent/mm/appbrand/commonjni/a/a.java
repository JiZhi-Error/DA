package com.tencent.mm.appbrand.commonjni.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.a.c;
import java.nio.ByteBuffer;

public final class a {

    public interface b {
        boolean doInnerLoopTask();

        String[] getAsyncableJsApis();

        String nativeInvokeHandler(String str, String str2, int i2, boolean z);

        ByteBuffer readWeAppFile(String str);

        void resumeLoopTasks();

        boolean syncInitModule(String str, String str2);
    }

    /* renamed from: com.tencent.mm.appbrand.commonjni.a.a$a  reason: collision with other inner class name */
    public static class C0266a implements b {
        @Override // com.tencent.mm.appbrand.commonjni.a.a.b
        public final String nativeInvokeHandler(String str, String str2, int i2, boolean z) {
            AppMethodBeat.i(201241);
            c.C0267c.i("MicroMsg.AppBrandRuntimeDelegate", "hy: trigger get nativeInvokeHandler jsapis", new Object[0]);
            AppMethodBeat.o(201241);
            return "";
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.a.b
        public final String[] getAsyncableJsApis() {
            return new String[0];
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.a.b
        public final ByteBuffer readWeAppFile(String str) {
            return null;
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.a.b
        public final void resumeLoopTasks() {
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.a.b
        public final boolean doInnerLoopTask() {
            return false;
        }

        @Override // com.tencent.mm.appbrand.commonjni.a.a.b
        public final boolean syncInitModule(String str, String str2) {
            return false;
        }
    }
}
