package com.tencent.mm.plugin.finder.activity;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/ActivityParamStore;", "", "()V", "Companion", "plugin-finder_release"})
public final class a {
    private static Intent tqe;
    public static final C1086a tqf = new C1086a((byte) 0);

    static {
        AppMethodBeat.i(241997);
        AppMethodBeat.o(241997);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/ActivityParamStore$Companion;", "", "()V", "TAG", "", "storeIntent", "Landroid/content/Intent;", "getStoreIntent", "()Landroid/content/Intent;", "setStoreIntent", "(Landroid/content/Intent;)V", "reset", "", "restore", "intent", "save", "setActivityParam", "srcIntent", "dstIntent", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.activity.a$a  reason: collision with other inner class name */
    public static final class C1086a {
        private C1086a() {
        }

        public /* synthetic */ C1086a(byte b2) {
            this();
        }

        public static void a(Intent intent, Intent intent2) {
            AppMethodBeat.i(241996);
            int intExtra = intent.getIntExtra("key_activity_type", 0);
            boolean booleanExtra = intent.getBooleanExtra("saveActivity", false);
            if (intExtra == 102 && booleanExtra) {
                intent2.putExtra("saveActivity", true);
                intent2.putExtra("key_activity_type", 102);
                String stringExtra = intent.getStringExtra("key_user_name");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                intent2.putExtra("key_user_name", stringExtra);
                String stringExtra2 = intent.getStringExtra("key_nick_name");
                if (stringExtra2 == null) {
                    stringExtra2 = "";
                }
                intent2.putExtra("key_nick_name", stringExtra2);
                String stringExtra3 = intent.getStringExtra("key_cover_url");
                if (stringExtra3 == null) {
                    stringExtra3 = "";
                }
                intent2.putExtra("key_cover_url", stringExtra3);
                String stringExtra4 = intent.getStringExtra("key_avatar_url");
                if (stringExtra4 == null) {
                    stringExtra4 = "";
                }
                intent2.putExtra("key_avatar_url", stringExtra4);
                intent2.putExtra("key_topic_id", intent.getLongExtra("key_topic_id", 0));
                String stringExtra5 = intent.getStringExtra("key_activity_name");
                if (stringExtra5 == null) {
                    stringExtra5 = "";
                }
                intent2.putExtra("key_activity_name", stringExtra5);
                String stringExtra6 = intent.getStringExtra("key_activity_desc");
                if (stringExtra6 == null) {
                    stringExtra6 = "";
                }
                intent2.putExtra("key_activity_desc", stringExtra6);
            }
            AppMethodBeat.o(241996);
        }
    }
}
