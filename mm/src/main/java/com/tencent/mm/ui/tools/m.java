package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o;

public final class m extends t {
    private boolean CSQ = true;
    public o.f HLX;
    public o.g HLY;
    private o.b HMa;
    private o.c HMb;
    private com.tencent.mm.ui.base.m HMc;
    private a Qva;
    private LayoutInflater mInflater;

    public m(Context context) {
        super(context);
        AppMethodBeat.i(143176);
        this.mInflater = aa.jQ(context);
        this.HMc = new com.tencent.mm.ui.base.m(context);
        AppMethodBeat.o(143176);
    }

    @Override // com.tencent.mm.ui.tools.t
    public final boolean iv() {
        AppMethodBeat.i(143177);
        if (this.HLX != null) {
            this.HLX.onCreateMMMenu(this.HMc);
        }
        this.CSQ = this.HMc.agy != null && this.HMc.agy.length() > 0;
        boolean iv = super.iv();
        AppMethodBeat.o(143177);
        return iv;
    }

    @Override // com.tencent.mm.ui.tools.t, android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(143178);
        if (!this.CSQ || i2 != 0) {
            if (this.CSQ) {
                i2--;
            }
            if (this.HLY != null) {
                this.HLY.onMMMenuItemSelected(this.HMc.getItem(i2), i2);
            }
            dismiss();
            AppMethodBeat.o(143178);
            return;
        }
        AppMethodBeat.o(143178);
    }

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(m mVar, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(143172);
            if (m.this.CSQ) {
                int size = m.this.HMc.size() + 1;
                AppMethodBeat.o(143172);
                return size;
            }
            int size2 = m.this.HMc.size();
            AppMethodBeat.o(143172);
            return size2;
        }

        public final Object getItem(int i2) {
            return null;
        }

        public final long getItemId(int i2) {
            return 0;
        }

        public final int getItemViewType(int i2) {
            AppMethodBeat.i(143173);
            if (!m.this.CSQ) {
                AppMethodBeat.o(143173);
                return 1;
            } else if (i2 == 0) {
                AppMethodBeat.o(143173);
                return 0;
            } else {
                AppMethodBeat.o(143173);
                return 1;
            }
        }

        public final int getViewTypeCount() {
            AppMethodBeat.i(143174);
            if (m.this.CSQ) {
                AppMethodBeat.o(143174);
                return 2;
            }
            AppMethodBeat.o(143174);
            return 1;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C2132a aVar;
            C2132a aVar2;
            AppMethodBeat.i(143175);
            if (!m.this.CSQ || i2 != 0) {
                if (m.this.CSQ) {
                    i2--;
                }
                if (view == null) {
                    view = m.this.mInflater.inflate(R.layout.bad, viewGroup, false);
                    C2132a aVar3 = new C2132a(this, (byte) 0);
                    aVar3.hbb = (TextView) view.findViewById(R.id.ipm);
                    aVar3.kc = (ImageView) view.findViewById(R.id.dt5);
                    aVar3.gvQ = view.findViewById(R.id.h8v);
                    view.setTag(aVar3);
                    aVar = aVar3;
                } else {
                    aVar = (C2132a) view.getTag();
                }
                MenuItem item = m.this.HMc.getItem(i2);
                aVar.hbb.setText(item.getTitle());
                if (item.getIcon() != null) {
                    aVar.kc.setVisibility(0);
                    aVar.kc.setImageDrawable(item.getIcon());
                } else if (m.this.HMa != null) {
                    aVar.kc.setVisibility(0);
                    m.this.HMa.a(aVar.kc, item);
                } else {
                    aVar.kc.setVisibility(8);
                }
                if (m.this.HMb != null) {
                    m.this.HMb.a(aVar.hbb, item);
                }
                if (i2 == m.this.HMc.size() - 1) {
                    aVar.gvQ.setBackgroundResource(R.drawable.axz);
                } else {
                    aVar.gvQ.setBackgroundResource(R.drawable.axy);
                }
            } else {
                if (view == null) {
                    view = m.this.mInflater.inflate(R.layout.bae, viewGroup, false);
                    C2132a aVar4 = new C2132a(this, (byte) 0);
                    aVar4.hbb = (TextView) view.findViewById(R.id.ipm);
                    aVar4.kc = (ImageView) view.findViewById(R.id.dt5);
                    view.setTag(aVar4);
                    aVar2 = aVar4;
                } else {
                    aVar2 = (C2132a) view.getTag();
                }
                aVar2.hbb.setText(m.f(m.this));
            }
            AppMethodBeat.o(143175);
            return view;
        }

        /* renamed from: com.tencent.mm.ui.tools.m$a$a  reason: collision with other inner class name */
        class C2132a {
            View gvQ;
            TextView hbb;
            ImageView kc;

            private C2132a() {
            }

            /* synthetic */ C2132a(a aVar, byte b2) {
                this();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.tools.t
    public final BaseAdapter anl() {
        AppMethodBeat.i(143179);
        if (this.Qva == null) {
            this.Qva = new a(this, (byte) 0);
        }
        a aVar = this.Qva;
        AppMethodBeat.o(143179);
        return aVar;
    }

    static /* synthetic */ CharSequence f(m mVar) {
        AppMethodBeat.i(143180);
        if (mVar.HMc.agy == null || mVar.HMc.agy.length() == 0) {
            String string = mVar.mContext.getResources().getString(R.string.t1);
            AppMethodBeat.o(143180);
            return string;
        }
        CharSequence charSequence = mVar.HMc.agy;
        AppMethodBeat.o(143180);
        return charSequence;
    }
}
