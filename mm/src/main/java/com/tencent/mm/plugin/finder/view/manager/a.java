package com.tencent.mm.plugin.finder.view.manager;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0002./B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020$J\u001e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+J\u0016\u0010,\u001a\u00020!2\u0006\u0010'\u001a\u00020(2\u0006\u0010-\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000e¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager;", "", "()V", "activityBtn", "Landroid/view/View;", "getActivityBtn", "()Landroid/view/View;", "setActivityBtn", "(Landroid/view/View;)V", "activityDesc", "", "getActivityDesc", "()Ljava/lang/String;", "setActivityDesc", "(Ljava/lang/String;)V", "activityName", "getActivityName", "setActivityName", "eventTopicId", "", "getEventTopicId", "()J", "setEventTopicId", "(J)V", "isExistActivity", "", "()Z", "setExistActivity", "(Z)V", "spanContent", "getSpanContent", "setSpanContent", "extractTopicAndSetSpan", "", "curDesc", "s", "Landroid/text/Editable;", "onBeforeTextChanged", "Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager$TextDeleteRecord;", "editText", "Lcom/tencent/mm/ui/widget/MMEditText;", "beforeText", "count", "", "setActivityContent", "nickName", "Companion", "TextDeleteRecord", "plugin-finder_release"})
public final class a {
    private static final String TAG = TAG;
    private static final String wsC = wsC;
    private static final String wsD = wsD;
    private static final char wsE = wsE;
    public static final C1342a wsF = new C1342a((byte) 0);
    private String activityName = "";
    private String trk = "";
    View wsA;
    boolean wsB;
    String wsz = "";

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderActivityPostManager$Companion;", "", "()V", "ACTIVITY_PREFIX_SPLIT_STR", "", "getACTIVITY_PREFIX_SPLIT_STR", "()Ljava/lang/String;", "ACTIVITY_PREFIX_STR", "getACTIVITY_PREFIX_STR", "ACTIVITY_SURFIX_CHAR", "", "getACTIVITY_SURFIX_CHAR", "()C", "TAG", "getTAG", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.view.manager.a$a  reason: collision with other inner class name */
    public static final class C1342a {
        private C1342a() {
        }

        public /* synthetic */ C1342a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(255246);
        AppMethodBeat.o(255246);
    }
}
