package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KProfessionEditView;
import com.tencent.kinda.gen.KProfessionEditViewOnSelectProfessionCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.py;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.protocal.protobuf.dex;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KindaProfessionEditViewImpl extends MMKView<View> implements KProfessionEditView {
    private byte _hellAccFlag_;
    KProfessionEditViewOnSelectProfessionCallback callback;
    private Context mContext;
    private Profession mCurSelectedProfession;
    private EditText mEditText;
    private IListener<py> professionSelectedEventIListener = new IListener<py>() {
        /* class com.tencent.kinda.framework.widget.base.KindaProfessionEditViewImpl.AnonymousClass1 */

        {
            AppMethodBeat.i(160761);
            this.__eventId = py.class.getName().hashCode();
            AppMethodBeat.o(160761);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public /* bridge */ /* synthetic */ boolean callback(py pyVar) {
            AppMethodBeat.i(18923);
            boolean callback = callback(pyVar);
            AppMethodBeat.o(18923);
            return callback;
        }

        public boolean callback(py pyVar) {
            AppMethodBeat.i(18922);
            if (KindaWrapProfessionActivity.ACTIVITY_CLOSE_FLAG.equals(pyVar.dWd.dWe)) {
                KindaProfessionEditViewImpl.this.professionSelectedEventIListener.dead();
            } else {
                Log.i(MMKView.TAG, "profession_name:" + pyVar.dWd.dWe + " profession_type:" + pyVar.dWd.dWf);
                KindaProfessionEditViewImpl.this.mCurSelectedProfession = new Profession(pyVar.dWd.dWe, pyVar.dWd.dWf);
                KindaProfessionEditViewImpl.this.mEditText.setText(KindaProfessionEditViewImpl.this.mCurSelectedProfession.HTX);
                if (KindaProfessionEditViewImpl.this.callback != null) {
                    KindaProfessionEditViewImpl.this.callback.onSelectProfession(KindaProfessionEditViewImpl.this.mCurSelectedProfession.HTX, KindaProfessionEditViewImpl.this.mCurSelectedProfession.HTY);
                }
            }
            AppMethodBeat.o(18922);
            return false;
        }
    };
    private final List<Profession> professions = new ArrayList();

    public KindaProfessionEditViewImpl() {
        AppMethodBeat.i(18924);
        AppMethodBeat.o(18924);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public View createView(Context context) {
        AppMethodBeat.i(18930);
        this.mEditText = new EditText(context);
        this.mEditText.setInputType(0);
        this.mEditText.setFocusable(false);
        this.mEditText.setBackground(null);
        this.mEditText.setHint(R.string.ia4);
        this.mEditText.setTextSize(0, MMKViewUtil.dpToPx(context, 17.0f));
        this.mEditText.setPadding(0, 0, 0, 0);
        this.mContext = context;
        LayoutWrapper layoutWrapper = new LayoutWrapper(context, this.mEditText);
        AppMethodBeat.o(18930);
        return layoutWrapper;
    }

    @Override // com.tencent.kinda.gen.KProfessionEditView
    public void setData(ITransmitKvData iTransmitKvData) {
        AppMethodBeat.i(18926);
        dex dex = new dex();
        try {
            dex.parseFrom(iTransmitKvData.getBinary("profession_list"));
        } catch (Exception e2) {
            Log.e(MMKView.TAG, "profession list parse failed");
        }
        this.professions.clear();
        Iterator<dew> it = dex.MJX.iterator();
        while (it.hasNext()) {
            dew next = it.next();
            this.professions.add(new Profession(next.dWe, next.dWf));
        }
        AppMethodBeat.o(18926);
    }

    @Override // com.tencent.kinda.gen.KProfessionEditView
    public void setDefaultProfession(int i2, String str) {
        AppMethodBeat.i(18927);
        this.mCurSelectedProfession = new Profession(str, i2);
        this.mEditText.setText(this.mCurSelectedProfession.HTX);
        AppMethodBeat.o(18927);
    }

    @Override // com.tencent.kinda.gen.KProfessionEditView
    public void setOnSelectProfessionCallback(KProfessionEditViewOnSelectProfessionCallback kProfessionEditViewOnSelectProfessionCallback) {
        this.callback = kProfessionEditViewOnSelectProfessionCallback;
    }

    @Override // com.tencent.kinda.gen.KProfessionEditView
    public void setFocus(boolean z) {
        AppMethodBeat.i(18928);
        if (z) {
            this.professionSelectedEventIListener.alive();
            if (this.mContext instanceof BaseFrActivity) {
                ((BaseFrActivity) this.mContext).hideTenpayKB();
                Intent intent = new Intent(this.mContext, KindaWrapProfessionActivity.class);
                intent.putExtra("key_profession_list", (Parcelable[]) this.professions.toArray(new Profession[this.professions.size()]));
                Context context = this.mContext;
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/kinda/framework/widget/base/KindaProfessionEditViewImpl", "setFocus", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/kinda/framework/widget/base/KindaProfessionEditViewImpl", "setFocus", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
        }
        AppMethodBeat.o(18928);
    }

    @Override // com.tencent.kinda.gen.KProfessionEditView
    public boolean getFocus() {
        AppMethodBeat.i(18929);
        boolean isFocused = this.mEditText.isFocused();
        AppMethodBeat.o(18929);
        return isFocused;
    }

    @Override // com.tencent.kinda.gen.KProfessionEditView
    public String getProfessionName() {
        if (this.mCurSelectedProfession != null) {
            return this.mCurSelectedProfession.HTX;
        }
        return null;
    }

    @Override // com.tencent.kinda.gen.KProfessionEditView
    public int getProfessionType() {
        if (this.mCurSelectedProfession != null) {
            return this.mCurSelectedProfession.HTY;
        }
        return 0;
    }
}
