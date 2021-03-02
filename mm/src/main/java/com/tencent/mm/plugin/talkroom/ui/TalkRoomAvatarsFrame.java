package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMHorList;
import java.util.LinkedList;
import java.util.List;

public class TalkRoomAvatarsFrame extends FrameLayout {
    private final int FQX = 2000;
    private final int FQY = 5;
    private MMHorList FQZ;
    private a FRa;
    private MTimerHandler FRb;
    private MMHandler mHandler;
    private final int yIK = com.tencent.mm.cb.a.fromDPToPix((Context) null, 58);
    private String yIY;

    static /* synthetic */ void d(TalkRoomAvatarsFrame talkRoomAvatarsFrame) {
        AppMethodBeat.i(29588);
        talkRoomAvatarsFrame.eco();
        AppMethodBeat.o(29588);
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(29582);
        initView();
        AppMethodBeat.o(29582);
    }

    public TalkRoomAvatarsFrame(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(29583);
        initView();
        AppMethodBeat.o(29583);
    }

    private void initView() {
        AppMethodBeat.i(29584);
        inflate(getContext(), R.layout.c1h, this);
        this.FQZ = (MMHorList) findViewById(R.id.dpy);
        this.FQZ.setOverScrollEnabled(true);
        this.FQZ.setCenterInParent(true);
        this.FQZ.setItemWidth(this.yIK);
        this.FRa = new a(getContext());
        this.FQZ.setAdapter((ListAdapter) this.FRa);
        this.mHandler = new MMHandler(Looper.getMainLooper());
        this.FQZ.setHorListLitener(new MMHorList.a() {
            /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.MMHorList.a
            public final void fuk() {
                AppMethodBeat.i(29573);
                TalkRoomAvatarsFrame.this.FRb.stopTimer();
                AppMethodBeat.o(29573);
            }

            @Override // com.tencent.mm.ui.base.MMHorList.a
            public final void fdM() {
                AppMethodBeat.i(29574);
                TalkRoomAvatarsFrame.this.FRb.startTimer(2000);
                AppMethodBeat.o(29574);
            }

            @Override // com.tencent.mm.ui.base.MMHorList.a
            public final void efW() {
                AppMethodBeat.i(29575);
                TalkRoomAvatarsFrame.this.mHandler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(29572);
                        TalkRoomAvatarsFrame.this.FRa.notifyDataSetChanged();
                        AppMethodBeat.o(29572);
                    }
                });
                AppMethodBeat.o(29575);
            }
        });
        this.FRb = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(29576);
                TalkRoomAvatarsFrame.d(TalkRoomAvatarsFrame.this);
                AppMethodBeat.o(29576);
                return false;
            }
        }, false);
        AppMethodBeat.o(29584);
    }

    public void setMembersList(List<String> list) {
        AppMethodBeat.i(29585);
        if (this.FRa == null) {
            AppMethodBeat.o(29585);
            return;
        }
        a aVar = this.FRa;
        if (list == null) {
            aVar.FRe.clear();
        } else {
            aVar.FRe = list;
        }
        aVar.notifyDataSetChanged();
        AppMethodBeat.o(29585);
    }

    public void setCurMemeber(String str) {
        AppMethodBeat.i(29586);
        if (this.FQZ == null) {
            AppMethodBeat.o(29586);
        } else if (Util.isNullOrNil(this.yIY) && Util.isNullOrNil(str)) {
            AppMethodBeat.o(29586);
        } else if (Util.isNullOrNil(this.yIY) || !this.yIY.equals(str)) {
            this.yIY = str;
            eco();
            AppMethodBeat.o(29586);
        } else {
            AppMethodBeat.o(29586);
        }
    }

    private void eco() {
        AppMethodBeat.i(29587);
        this.FRa.yIY = this.yIY;
        if (Util.isNullOrNil(this.yIY)) {
            this.FRa.notifyDataSetChanged();
            AppMethodBeat.o(29587);
        } else if (this.FQZ.getIsTouching()) {
            AppMethodBeat.o(29587);
        } else {
            int indexOf = this.FRa.indexOf(this.yIY) * this.yIK;
            int currentPosition = this.FQZ.getCurrentPosition();
            if (indexOf < currentPosition) {
                this.FQZ.alA(indexOf);
                AppMethodBeat.o(29587);
            } else if (indexOf > currentPosition + (this.yIK * 4)) {
                this.FQZ.alA(indexOf - (this.yIK * 4));
                AppMethodBeat.o(29587);
            } else {
                this.FRa.notifyDataSetChanged();
                AppMethodBeat.o(29587);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends BaseAdapter {
        List<String> FRe = new LinkedList();
        private Context mContext;
        String yIY;

        public a(Context context) {
            AppMethodBeat.i(29577);
            this.mContext = context;
            AppMethodBeat.o(29577);
        }

        public final int indexOf(String str) {
            AppMethodBeat.i(29578);
            int indexOf = this.FRe.indexOf(str);
            AppMethodBeat.o(29578);
            return indexOf;
        }

        public final int getCount() {
            AppMethodBeat.i(29579);
            int size = this.FRe.size();
            AppMethodBeat.o(29579);
            return size;
        }

        public final Object getItem(int i2) {
            AppMethodBeat.i(29580);
            String str = this.FRe.get(i2);
            AppMethodBeat.o(29580);
            return str;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1799a aVar;
            AppMethodBeat.i(29581);
            String str = this.FRe.get(i2);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.c1i, null);
                C1799a aVar2 = new C1799a();
                aVar2.gvv = (ImageView) view.findViewById(R.id.e47);
                aVar2.gvw = (TextView) view.findViewById(R.id.iy6);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1799a) view.getTag();
            }
            aVar.gvv.setBackgroundResource(str.equals(this.yIY) ? R.drawable.bod : 0);
            aVar.gvw.setVisibility(8);
            a.b.A(aVar.gvv, str);
            AppMethodBeat.o(29581);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.talkroom.ui.TalkRoomAvatarsFrame$a$a  reason: collision with other inner class name */
        class C1799a {
            public ImageView gvv;
            public TextView gvw;

            C1799a() {
            }
        }
    }
}
