package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gs;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.story.f.i;
import com.tencent.mm.plugin.story.f.j;
import com.tencent.mm.protocal.protobuf.eel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

public final class f extends gs {
    private static final m<Long, Long, Boolean> Fwd = b.Fwf;
    public static final a Fwe = new a((byte) 0);
    private static final String TAG = TAG;
    private static final IAutoDBItem.MAutoDBInfo info = gs.ajs();
    private int ecf;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class b extends q implements m<Long, Long, Boolean> {
        public static final b Fwf = new b();

        static {
            AppMethodBeat.i(119489);
            AppMethodBeat.o(119489);
        }

        b() {
            super(2);
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ Boolean invoke(Long l, Long l2) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(119488);
            long longValue = l.longValue();
            long longValue2 = l2.longValue();
            if (longValue < longValue2) {
                z = true;
            } else {
                z = false;
            }
            if (longValue < 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z4 = z2 ^ z;
            if (longValue2 >= 0) {
                z3 = false;
            }
            Boolean valueOf = Boolean.valueOf(z3 ^ z4);
            AppMethodBeat.o(119488);
            return valueOf;
        }
    }

    public f() {
        AppMethodBeat.i(119499);
        setUserName("");
        AppMethodBeat.o(119499);
    }

    static {
        AppMethodBeat.i(119500);
        AppMethodBeat.o(119500);
    }

    public final String getUserName() {
        AppMethodBeat.i(119490);
        String str = this.field_userName;
        p.g(str, "field_userName");
        AppMethodBeat.o(119490);
        return str;
    }

    public final void setUserName(String str) {
        AppMethodBeat.i(119491);
        p.h(str, "value");
        this.field_userName = str;
        AppMethodBeat.o(119491);
    }

    public final String frx() {
        String str = this.field_newVideoUrl;
        return str == null ? "" : str;
    }

    public final String aBE() {
        String str = this.field_newThumbUrl;
        return str == null ? "" : str;
    }

    public final void aSs(String str) {
        AppMethodBeat.i(119492);
        p.h(str, "value");
        this.field_preloadMediaId = str;
        AppMethodBeat.o(119492);
    }

    public final eel frz() {
        eel eel;
        AppMethodBeat.i(119493);
        if (this.field_userInfo == null) {
            eel eel2 = new eel();
            AppMethodBeat.o(119493);
            return eel2;
        }
        try {
            com.tencent.mm.bw.a parseFrom = new eel().parseFrom(this.field_userInfo);
            if (parseFrom == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.StoryUserInfo");
                AppMethodBeat.o(119493);
                throw tVar;
            }
            eel = (eel) parseFrom;
            AppMethodBeat.o(119493);
            return eel;
        } catch (Exception e2) {
            Log.e(TAG, "error get storyUserInfo!");
            eel = new eel();
        }
    }

    @Override // com.tencent.mm.g.c.gs, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(119495);
        p.h(cursor, "cu");
        super.convertFrom(cursor);
        this.ecf = (int) this.systemRowid;
        AppMethodBeat.o(119495);
    }

    public final boolean frA() {
        AppMethodBeat.i(119496);
        if (isValid() && Fwd.invoke(Long.valueOf(this.field_readId), Long.valueOf(this.field_syncId)).booleanValue()) {
            m<Long, Long, Boolean> mVar = Fwd;
            j.b bVar = j.Fmy;
            if (mVar.invoke(Long.valueOf(j.b.fop()), Long.valueOf(this.field_updateTime)).booleanValue()) {
                AppMethodBeat.o(119496);
                return true;
            }
        }
        AppMethodBeat.o(119496);
        return false;
    }

    public final boolean isValid() {
        AppMethodBeat.i(119497);
        if (this.field_syncId != 0) {
            int i2 = this.field_storyPostTime;
            i.a aVar = i.Fmb;
            if (i2 + i.FlY >= cl.aWB()) {
                AppMethodBeat.o(119497);
                return true;
            }
        }
        AppMethodBeat.o(119497);
        return false;
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        AppMethodBeat.i(119498);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = info;
        p.g(mAutoDBInfo, "StoryExtInfo.info");
        AppMethodBeat.o(119498);
        return mAutoDBInfo;
    }

    public final long fry() {
        if (this.field_preloadStoryId == this.field_syncId) {
            return this.field_preLoadResource;
        }
        return 0;
    }

    public final boolean b(long j2, String str, int i2) {
        AppMethodBeat.i(119494);
        p.h(str, "mediaId");
        if (j2 == this.field_syncId) {
            this.field_preloadStoryId = j2;
            aSs(str);
            this.field_preLoadResource = (long) i2;
            AppMethodBeat.o(119494);
            return true;
        }
        AppMethodBeat.o(119494);
        return false;
    }
}
