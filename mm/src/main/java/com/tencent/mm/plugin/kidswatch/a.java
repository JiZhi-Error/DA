package com.tencent.mm.plugin.kidswatch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ConstantsKidsWatch;", "", "()V", "Companion", "ExtDeviceLoginRet", "LoginFirstChooseScene", "plugin-kidswatch_release"})
public final class a {
    public static final C1450a yAh = new C1450a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ConstantsKidsWatch$LoginFirstChooseScene;", "", "(Ljava/lang/String;I)V", "SCENE_CHOOSE_LOGIN", "SCENE_CHOOSE_REG", "plugin-kidswatch_release"})
    public enum c {
        SCENE_CHOOSE_LOGIN,
        SCENE_CHOOSE_REG;

        static {
            AppMethodBeat.i(256171);
            AppMethodBeat.o(256171);
        }

        public static c valueOf(String str) {
            AppMethodBeat.i(256173);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(256173);
            return cVar;
        }
    }

    static {
        AppMethodBeat.i(256174);
        AppMethodBeat.o(256174);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ConstantsKidsWatch$Companion;", "", "()V", "BUTTON_BIG_MARGIN_BOTTOM_DP", "", "BUTTON_SMALL_MARGIN_BOTTOM_DP", "CARD_BIG_MARGIN_DP", "CARD_SMALL_MARGIN_DP", "INTENT_KEY_DEVICE_NAME_STRING", "", "INTENT_KEY_KIDS_COUNT", "INTENT_KEY_KIDS_LIST", "INTENT_KEY_LOGIN_URL", "INTENT_KEY_OK_SESSION_LIST", "INTENT_KEY_REG_BTN", "INTENT_KEY_REG_HAS_SET_AVATAR", "INTENT_KEY_REG_HEAD_IMG_AES_KEY", "INTENT_KEY_REG_HEAD_IMG_FILE_ID", "INTENT_KEY_REG_LAST_HEAD_IMG_URL", "INTENT_KEY_REG_LAST_NICKNAME", "INTENT_KEY_REG_MOBILE", "INTENT_KEY_REG_NICKNAME", "INTENT_KEY_REG_OPEN_ID", "INTENT_KEY_REG_REG_SESSION_ID", "INTENT_KEY_SCENE_ENTER_LOGIN_FIRST", "LOGIN_FIRST_SCENE_CARD", "LOGIN_FIRST_SCENE_SCAN", "MINI_PROGRAM_APP_ID", "MINI_PROGRAM_FEATURE_INTRO_PATH", "MINI_PROGRAM_FEATURE_MANAGER_PATH", "MM_KIDS_WATCH_MINI_PROGRAM", "MM_KIDS_WATCH_SCENE_NOTE_INTRO", "MM_KIDS_WATCH_SCENE_NOTE_PROFILE", "REQUEST_SAFE_VERIFY", "REQUEST_SHOW_AGREEMENTS_UI", "SCREEN_WIDTH_SPLIT_DP", "plugin-kidswatch_release"})
    /* renamed from: com.tencent.mm.plugin.kidswatch.a$a  reason: collision with other inner class name */
    public static final class C1450a {
        private C1450a() {
        }

        public /* synthetic */ C1450a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/kidswatch/ConstantsKidsWatch$ExtDeviceLoginRet;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ExtDeviceLoginRet_Ok", "ExtDeviceLoginRet_Error", "ExtDeviceLoginRet_Expired", "ExtDeviceLoginRet_UnSupportDev", "ExtDeviceLoginRet_UnSupportApp", "ExtDeviceLoginRet_UnSupportClient_CanUpdate", "ExtDeviceLoginRet_UnSupportClient_NoUpdate", "ExtDeviceLoginRet_Error_NeedNotify", "ExtDeviceLoginRet_Error_AlbumBind", "ExtDeviceLoginRet_Sapm", "plugin-kidswatch_release"})
    public enum b {
        ExtDeviceLoginRet_Ok(0),
        ExtDeviceLoginRet_Error(-1),
        ExtDeviceLoginRet_Expired(-2),
        ExtDeviceLoginRet_UnSupportDev(-3),
        ExtDeviceLoginRet_UnSupportApp(-4),
        ExtDeviceLoginRet_UnSupportClient_CanUpdate(-5),
        ExtDeviceLoginRet_UnSupportClient_NoUpdate(-6),
        ExtDeviceLoginRet_Error_NeedNotify(-7),
        ExtDeviceLoginRet_Error_AlbumBind(8),
        ExtDeviceLoginRet_Sapm(-9);
        
        public final int value;

        public static b valueOf(String str) {
            AppMethodBeat.i(256170);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(256170);
            return bVar;
        }

        private b(int i2) {
            this.value = i2;
        }

        static {
            AppMethodBeat.i(256168);
            AppMethodBeat.o(256168);
        }
    }
}
