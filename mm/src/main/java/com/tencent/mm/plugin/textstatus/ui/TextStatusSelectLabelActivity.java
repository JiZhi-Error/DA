package com.tencent.mm.plugin.textstatus.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSelectLabelActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "rgVisibleGroup", "Landroid/widget/RadioGroup;", "getRgVisibleGroup", "()Landroid/widget/RadioGroup;", "setRgVisibleGroup", "(Landroid/widget/RadioGroup;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusSelectLabelActivity extends MMActivity {
    public static final a GfL = new a((byte) 0);
    private RadioGroup GfK;

    static {
        AppMethodBeat.i(216662);
        AppMethodBeat.o(216662);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSelectLabelActivity$Companion;", "", "()V", "startForResult", "", "context", "Landroid/app/Activity;", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c2w;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(216661);
        super.onCreate(bundle);
        setMMTitle(R.string.ho6);
        this.GfK = (RadioGroup) findViewById(R.id.h6k);
        RadioGroup radioGroup = this.GfK;
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new b(this));
            AppMethodBeat.o(216661);
            return;
        }
        AppMethodBeat.o(216661);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "group", "Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "checkedId", "", "onCheckedChanged"})
    static final class b implements RadioGroup.OnCheckedChangeListener {
        final /* synthetic */ TextStatusSelectLabelActivity GfM;

        b(TextStatusSelectLabelActivity textStatusSelectLabelActivity) {
            this.GfM = textStatusSelectLabelActivity;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            AppMethodBeat.i(216660);
            Intent intent = new Intent();
            intent.putExtra("SELECT_VISIBILITY", i2);
            this.GfM.setResult(-1, intent);
            this.GfM.finish();
            AppMethodBeat.o(216660);
        }
    }
}
