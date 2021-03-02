package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.g;

public final class k extends MAutoStorage<j> implements g.a {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(j.info, "EmotionDesignerInfo")};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(105114);
        AppMethodBeat.o(105114);
    }

    public enum a {
        DesignerSimpleInfo(0),
        PersonalDesigner(1),
        DesignerEmojiList(2);
        
        public int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(105110);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(105110);
            return aVar;
        }

        static {
            AppMethodBeat.i(105111);
            AppMethodBeat.o(105111);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    public k(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, j.info, "EmotionDesignerInfo", null);
        this.db = iSQLiteDatabase;
    }

    @Override // com.tencent.mm.storagebase.g.a
    public final int a(g gVar) {
        this.db = gVar;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.protocal.protobuf.bmi blr(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 154
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.k.blr(java.lang.String):com.tencent.mm.protocal.protobuf.bmi");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.protocal.protobuf.bmg bls(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 154
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.emotion.k.bls(java.lang.String):com.tencent.mm.protocal.protobuf.bmg");
    }
}
