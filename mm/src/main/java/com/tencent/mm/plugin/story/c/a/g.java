package com.tencent.mm.plugin.story.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.story.c.a;
import com.tencent.mm.plugin.story.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0004\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig;", "Lcom/tencent/mm/plugin/story/config/StoryElementConfig;", "Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "()V", "DEFAULT_VALUE", "TAG", "", "getTAG", "()Ljava/lang/String;", "getElementName", "Lcom/tencent/mm/plugin/story/config/StoryConfigConstant$ElementName;", "initDefaultConfig", "loadConfig", "", "loadDebugConfig", "", "loadServerConfig", "update", "parse", "StoryProcessType", "plugin-story_release"})
public final class g extends b<a> {
    private static final a Flr = a.BACKGROUND;
    public static final g Fls = new g();
    private static final String TAG = TAG;

    static {
        AppMethodBeat.i(118617);
        AppMethodBeat.o(118617);
    }

    private g() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/story/config/moduleconfig/StoryProcessElementConfig$StoryProcessType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "FORWARD", "BACKGROUND", "plugin-story_release"})
    public enum a {
        FORWARD(0),
        BACKGROUND(1);
        
        public final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(118615);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(118615);
            return aVar;
        }

        private a(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(118613);
            AppMethodBeat.o(118613);
        }
    }

    @Override // com.tencent.mm.media.b.c
    public final /* bridge */ /* synthetic */ Object aLR() {
        return a.BACKGROUND;
    }

    @Override // com.tencent.mm.media.b.c
    public final void aLS() {
        AppMethodBeat.i(118616);
        Log.i(TAG, "loadDebugConfig false ");
        String string = MultiProcessMMKV.getMMKV(a.b.MODEL_STORY.name()).getString(a.EnumC1743a.ELEMENT_PROCESS_TYPE.name(), Flr.name());
        if (string == null) {
            p.hyc();
        }
        p.g(string, "mmkv.getString(getElemen…me, DEFAULT_VALUE.name)!!");
        bS(a.valueOf(string));
        int ab = ab("StoryBackgroundRemux", 0);
        if (ab != 0) {
            bS(ab == 1 ? a.BACKGROUND : a.FORWARD);
        }
        int i2 = ae.gKB.gJb;
        if (i2 != -1) {
            bS(i2 == 1 ? a.BACKGROUND : a.FORWARD);
        }
        Log.i(TAG, "loadServerConfig : " + ((a) aLQ()) + ", serverConfig:" + ab + ", deviceConfig:" + i2);
        AppMethodBeat.o(118616);
    }
}
