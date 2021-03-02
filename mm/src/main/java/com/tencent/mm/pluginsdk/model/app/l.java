package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.concurrent.ConcurrentHashMap;

public final class l extends MAutoStorage<k> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(k.info, "AppMessage")};
    private final a JWl = new a((byte) 0);

    public interface b {
        k GL(long j2);

        boolean GM(long j2);

        boolean a(k kVar, boolean z);

        boolean a(k kVar, boolean z, String... strArr);

        boolean b(k kVar, boolean z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insertNotify(k kVar, boolean z) {
        AppMethodBeat.i(223764);
        k kVar2 = kVar;
        if (this.JWl.GM(kVar2.field_msgId)) {
            boolean a2 = this.JWl.a(kVar2, z);
            AppMethodBeat.o(223764);
            return a2;
        }
        boolean insertNotify = super.insertNotify(kVar2, z);
        AppMethodBeat.o(223764);
        return insertNotify;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage
    public final /* synthetic */ boolean replace(k kVar, boolean z) {
        AppMethodBeat.i(223762);
        k kVar2 = kVar;
        if (this.JWl.GM(kVar2.field_msgId)) {
            boolean b2 = this.JWl.b(kVar2, z);
            AppMethodBeat.o(223762);
            return b2;
        }
        boolean replace = super.replace(kVar2, z);
        AppMethodBeat.o(223762);
        return replace;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.storage.IAutoDBItem, boolean, java.lang.String[]] */
    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean updateNotify(k kVar, boolean z, String[] strArr) {
        AppMethodBeat.i(223763);
        k kVar2 = kVar;
        if (this.JWl.GM(kVar2.field_msgId)) {
            boolean a2 = this.JWl.a(kVar2, z, strArr);
            AppMethodBeat.o(223763);
            return a2;
        }
        boolean updateNotify = super.updateNotify(kVar2, z, strArr);
        AppMethodBeat.o(223763);
        return updateNotify;
    }

    static {
        AppMethodBeat.i(151753);
        AppMethodBeat.o(151753);
    }

    public l(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, k.info, "AppMessage", null);
        AppMethodBeat.i(223759);
        AppMethodBeat.o(223759);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(223760);
        if (bVar == null) {
            AppMethodBeat.o(223760);
            return;
        }
        this.JWl.JWm.put(bVar, new Object());
        AppMethodBeat.o(223760);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(223761);
        this.JWl.JWm.remove(bVar);
        AppMethodBeat.o(223761);
    }

    public final k GL(long j2) {
        AppMethodBeat.i(151752);
        if (this.JWl.GM(j2)) {
            k GL = this.JWl.GL(j2);
            AppMethodBeat.o(151752);
            return GL;
        }
        k kVar = new k();
        kVar.field_msgId = j2;
        if (super.get(kVar, new String[0])) {
            AppMethodBeat.o(151752);
            return kVar;
        }
        AppMethodBeat.o(151752);
        return null;
    }

    static final class a implements b {
        ConcurrentHashMap<b, Object> JWm;

        private a() {
            AppMethodBeat.i(223753);
            this.JWm = new ConcurrentHashMap<>();
            AppMethodBeat.o(223753);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.pluginsdk.model.app.l.b
        public final boolean GM(long j2) {
            AppMethodBeat.i(223754);
            for (b bVar : this.JWm.keySet()) {
                if (bVar.GM(j2)) {
                    AppMethodBeat.o(223754);
                    return true;
                }
            }
            AppMethodBeat.o(223754);
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.model.app.l.b
        public final k GL(long j2) {
            AppMethodBeat.i(223755);
            for (b bVar : this.JWm.keySet()) {
                if (bVar.GM(j2)) {
                    k GL = bVar.GL(j2);
                    AppMethodBeat.o(223755);
                    return GL;
                }
            }
            AppMethodBeat.o(223755);
            return null;
        }

        @Override // com.tencent.mm.pluginsdk.model.app.l.b
        public final boolean b(k kVar, boolean z) {
            AppMethodBeat.i(223756);
            for (b bVar : this.JWm.keySet()) {
                if (bVar.GM(kVar.field_msgId)) {
                    boolean b2 = bVar.b(kVar, z);
                    AppMethodBeat.o(223756);
                    return b2;
                }
            }
            AppMethodBeat.o(223756);
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.model.app.l.b
        public final boolean a(k kVar, boolean z) {
            AppMethodBeat.i(223757);
            for (b bVar : this.JWm.keySet()) {
                if (bVar.GM(kVar.field_msgId)) {
                    boolean a2 = bVar.a(kVar, z);
                    AppMethodBeat.o(223757);
                    return a2;
                }
            }
            AppMethodBeat.o(223757);
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.model.app.l.b
        public final boolean a(k kVar, boolean z, String... strArr) {
            AppMethodBeat.i(223758);
            for (b bVar : this.JWm.keySet()) {
                if (bVar.GM(kVar.field_msgId)) {
                    boolean a2 = bVar.a(kVar, z, strArr);
                    AppMethodBeat.o(223758);
                    return a2;
                }
            }
            AppMethodBeat.o(223758);
            return false;
        }
    }
}
