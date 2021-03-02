package com.tencent.matrix.iocanary.a;

import com.tencent.c.a.a;

public final class a {
    public final com.tencent.c.a.a cQF;

    /* renamed from: com.tencent.matrix.iocanary.a.a$a  reason: collision with other inner class name */
    public static final class C0225a {
        public com.tencent.c.a.a cQF;
    }

    public /* synthetic */ a(com.tencent.c.a.a aVar, byte b2) {
        this(aVar);
    }

    private a(com.tencent.c.a.a aVar) {
        this.cQF = aVar;
    }

    public final boolean St() {
        return this.cQF.get(a.EnumC0131a.clicfg_matrix_io_file_io_main_thread_enable.name(), true);
    }

    public final boolean Su() {
        return this.cQF.get(a.EnumC0131a.clicfg_matrix_io_repeated_read_enable.name(), true);
    }

    public final boolean Sv() {
        return this.cQF.get(a.EnumC0131a.clicfg_matrix_io_small_buffer_enable.name(), true);
    }

    public final boolean Sw() {
        return this.cQF.get(a.EnumC0131a.clicfg_matrix_io_closeable_leak_enable.name(), true);
    }

    public final String toString() {
        return String.format("[IOCanary.IOConfig], main_thread:%b, small_buffer:%b, repeat_read:%b, closeable_leak:%b", Boolean.valueOf(St()), Boolean.valueOf(Sv()), Boolean.valueOf(Su()), Boolean.valueOf(Sw()));
    }
}
