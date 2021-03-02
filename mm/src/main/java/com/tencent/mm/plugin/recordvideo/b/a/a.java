package com.tencent.mm.plugin.recordvideo.b.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/IRecordBasicConfig;", "()V", "enableFavorite", "", "enableImage2Video", "enableLyrics", "enableMusic", "enableSnsNotify", "enableTips", "getDurationFromAlbum", "", "getElementName", "Lcom/tencent/mm/plugin/recordvideo/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "StoryBasicConfig", "plugin-recordvideo_release"})
public final class a extends h<C1638a> {
    public static final a BNL = new a();

    static {
        AppMethodBeat.i(75393);
        AppMethodBeat.o(75393);
    }

    private a() {
    }

    @Override // com.tencent.mm.media.b.c
    public final void aLS() {
        boolean z;
        boolean z2;
        C1638a aVar;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9 = true;
        AppMethodBeat.i(75390);
        C1638a aVar2 = (C1638a) aLQ();
        if (ab("StoryEditVideoBgmSwitch", 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar2.BNX = z;
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
        ((C1638a) aLQ()).BNY = fromDPToPix * 100;
        ((C1638a) aLQ()).BNZ = fromDPToPix * 100;
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) {
            ((C1638a) aLQ()).BNM = true;
            ((C1638a) aLQ()).BNN = true;
            ((C1638a) aLQ()).BNO = true;
            ((C1638a) aLQ()).BNR = true;
            ((C1638a) aLQ()).BNQ = true;
            aVar = (C1638a) aLQ();
            z2 = true;
        } else {
            C1638a aVar3 = (C1638a) aLQ();
            if (((b) g.af(b.class)).a(b.a.clicfg_story_favorite_enable, 0) == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            aVar3.BNM = z4;
            C1638a aVar4 = (C1638a) aLQ();
            if (((b) g.af(b.class)).a(b.a.clicfg_story_notify_sns_enable, 0) == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            aVar4.BNN = z5;
            C1638a aVar5 = (C1638a) aLQ();
            if (((b) g.af(b.class)).a(b.a.clicfg_story_reply_enable, 0) == 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            aVar5.BNO = z6;
            C1638a aVar6 = (C1638a) aLQ();
            if (((b) g.af(b.class)).a(b.a.clicfg_story_image_2_video_enable, 1) == 1) {
                z7 = true;
            } else {
                z7 = false;
            }
            aVar6.BNR = z7;
            C1638a aVar7 = (C1638a) aLQ();
            if (((b) g.af(b.class)).a(b.a.clicfg_story_edit_tip_enable, 1) == 1) {
                z8 = true;
            } else {
                z8 = false;
            }
            aVar7.BNQ = z8;
            aVar = (C1638a) aLQ();
            if (((b) g.af(b.class)).a(b.a.clicfg_story_big_mouth_blur_enable, 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        aVar.BNT = z2;
        ((C1638a) aLQ()).BNU = ab("StoryFeaturedExpiredTime", 15552000);
        ((C1638a) aLQ()).BNV = ((b) g.af(b.class)).a(b.a.clicfg_story_album_duration, 10);
        C1638a aVar8 = (C1638a) aLQ();
        if (((b) g.af(b.class)).a(b.a.clicfg_story_edit_lyrics_enable, 1) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        aVar8.BNP = z3;
        C1638a aVar9 = (C1638a) aLQ();
        if (((b) g.af(b.class)).a(b.a.clicfg_story_add_music_enable, 1) != 1) {
            z9 = false;
        }
        aVar9.BNS = z9;
        AppMethodBeat.o(75390);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b6\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J1\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u00108\u001a\u00020\u00052\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0003HÖ\u0001J\t\u0010;\u001a\u00020<HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001a\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010#\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010)\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016¨\u0006="}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/config/moduleconfig/BasicElementConfig$StoryBasicConfig;", "", "repeatMD5", "", "showMusicIcon", "", "albumThumbHeight", "albumThumbWidth", "(IZII)V", "getAlbumThumbHeight", "()I", "setAlbumThumbHeight", "(I)V", "getAlbumThumbWidth", "setAlbumThumbWidth", "durationFromAlbum", "getDurationFromAlbum", "setDurationFromAlbum", "enableBlurMouth", "getEnableBlurMouth", "()Z", "setEnableBlurMouth", "(Z)V", "enableFavorite", "getEnableFavorite", "setEnableFavorite", "enableImage2Video", "getEnableImage2Video", "setEnableImage2Video", "enableLyrics", "getEnableLyrics", "setEnableLyrics", "enableMusic", "getEnableMusic", "setEnableMusic", "enableReply", "getEnableReply", "setEnableReply", "enableSnsNotify", "getEnableSnsNotify", "setEnableSnsNotify", "enableTips", "getEnableTips", "setEnableTips", "favExpiredTime", "getFavExpiredTime", "setFavExpiredTime", "getRepeatMD5", "setRepeatMD5", "getShowMusicIcon", "setShowMusicIcon", "component1", "component2", "component3", "component4", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-recordvideo_release"})
    /* renamed from: com.tencent.mm.plugin.recordvideo.b.a.a$a  reason: collision with other inner class name */
    public static final class C1638a {
        boolean BNM;
        boolean BNN;
        boolean BNO;
        public boolean BNP;
        boolean BNQ;
        public boolean BNR;
        public boolean BNS;
        boolean BNT;
        int BNU;
        int BNV;
        private int BNW;
        boolean BNX;
        int BNY;
        int BNZ;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof C1638a) {
                    C1638a aVar = (C1638a) obj;
                    if (!(this.BNW == aVar.BNW && this.BNX == aVar.BNX && this.BNY == aVar.BNY && this.BNZ == aVar.BNZ)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = this.BNW * 31;
            boolean z = this.BNX;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return ((((i3 + i2) * 31) + this.BNY) * 31) + this.BNZ;
        }

        public final String toString() {
            AppMethodBeat.i(75388);
            String str = "StoryBasicConfig(repeatMD5=" + this.BNW + ", showMusicIcon=" + this.BNX + ", albumThumbHeight=" + this.BNY + ", albumThumbWidth=" + this.BNZ + ")";
            AppMethodBeat.o(75388);
            return str;
        }

        private C1638a() {
            this.BNW = 2;
            this.BNX = true;
            this.BNY = 0;
            this.BNZ = 0;
            this.BNS = true;
            this.BNU = 15552000;
            this.BNV = 10;
        }

        public /* synthetic */ C1638a(byte b2) {
            this();
        }
    }

    public final boolean eJD() {
        AppMethodBeat.i(75391);
        boolean z = ((C1638a) aLT()).BNN;
        AppMethodBeat.o(75391);
        return z;
    }

    public final int eJE() {
        AppMethodBeat.i(237257);
        int i2 = ((C1638a) aLT()).BNV;
        AppMethodBeat.o(237257);
        return i2;
    }

    @Override // com.tencent.mm.media.b.c
    public final /* synthetic */ Object aLR() {
        AppMethodBeat.i(75389);
        C1638a aVar = new C1638a((byte) 0);
        AppMethodBeat.o(75389);
        return aVar;
    }
}
