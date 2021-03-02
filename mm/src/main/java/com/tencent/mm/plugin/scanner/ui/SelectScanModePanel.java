package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectScanModePanel extends LinearLayout {
    private static int COl = 85;
    private static int COm = 85;
    private boolean COA = false;
    private int COB;
    private int COC;
    private MMFlipper COD;
    private MMDotView COE;
    private a COF;
    private boolean COn = r.eSf();
    private int COo = 4;
    private final int COp = 0;
    private int COq = 0;
    protected List<SelectScanModeGrid> COr;
    private String[] COs;
    private int[] COt = {R.drawable.cmg, R.drawable.cm9, R.drawable.cmi, R.raw.scan_translation, R.drawable.cm9};
    private int[] COu = {R.drawable.cmh, R.drawable.cm_, R.drawable.cmj, R.raw.scan_translation_hl, R.drawable.cm_};
    private int[] COv = {1, 2, 5, 3, 12};
    private ArrayList<Integer> COw = new ArrayList<>();
    private Set<Integer> COx = new HashSet();
    private AdapterView.OnItemClickListener COy;
    private int COz = 0;
    private Context context;

    public interface a {
    }

    static /* synthetic */ void c(SelectScanModePanel selectScanModePanel) {
        AppMethodBeat.i(51995);
        selectScanModePanel.eRo();
        AppMethodBeat.o(51995);
    }

    public SelectScanModePanel(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(51989);
        this.context = context2;
        View.inflate(this.context, R.layout.bpy, this);
        this.COE = (MMDotView) findViewById(R.id.hio);
        this.COw.clear();
        this.COw.add(1);
        this.COw.add(2);
        this.COw.add(5);
        this.COw.add(3);
        if (this.COn) {
            this.COw.add(12);
        }
        this.COo = this.COn ? 5 : 4;
        this.COs = new String[this.COo];
        this.COs[0] = this.context.getString(R.string.gbu);
        this.COs[1] = r.jR(r.CUF, this.context.getString(R.string.gbr));
        this.COs[2] = this.context.getString(R.string.gbw);
        this.COs[3] = this.context.getString(R.string.gbs);
        if (this.COn) {
            this.COs[4] = this.context.getString(R.string.gbo);
        }
        Log.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
        this.COD = (MMFlipper) findViewById(R.id.hip);
        View findViewById = findViewById(R.id.hin);
        if (this.context.getResources().getConfiguration().orientation == 2) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, (float) COm);
            findViewById.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams2.height = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, (float) COl);
            findViewById.setLayoutParams(layoutParams2);
        }
        this.COD.removeAllViews();
        this.COD.setOnMeasureListener(new MMFlipper.b() {
            /* class com.tencent.mm.plugin.scanner.ui.SelectScanModePanel.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.MMFlipper.b
            public final void ig(int i2, int i3) {
                AppMethodBeat.i(51986);
                Log.v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + i2 + " height:" + i3 + " isMeasured:" + SelectScanModePanel.this.COA);
                if (SelectScanModePanel.this.COA || i3 == 0 || i2 == 0) {
                    AppMethodBeat.o(51986);
                    return;
                }
                SelectScanModePanel.this.COA = true;
                SelectScanModePanel.this.COC = i3;
                SelectScanModePanel.this.COB = i2;
                SelectScanModePanel.c(SelectScanModePanel.this);
                AppMethodBeat.o(51986);
            }
        });
        this.COD.setOnScreenChangedListener(new MMFlipper.c() {
            /* class com.tencent.mm.plugin.scanner.ui.SelectScanModePanel.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.MMFlipper.c
            public final void z(int i2, int i3, boolean z) {
                AppMethodBeat.i(163474);
                SelectScanModePanel.this.COE.setSelectedDot(i3);
                AppMethodBeat.o(163474);
            }
        });
        AppMethodBeat.o(51989);
    }

    public void setOnGridItemClickCallback(a aVar) {
        this.COF = aVar;
    }

    public void setDisplayModes(int[] iArr) {
        AppMethodBeat.i(51990);
        this.COw.clear();
        for (int i2 : iArr) {
            this.COw.add(Integer.valueOf(i2));
        }
        eRo();
        AppMethodBeat.o(51990);
    }

    public void setShowRedDotModes(Set<Integer> set) {
        AppMethodBeat.i(51991);
        if (set != null) {
            this.COx.clear();
            this.COx.addAll(set);
        }
        AppMethodBeat.o(51991);
    }

    public void setSelectedMode(int i2) {
        AppMethodBeat.i(51992);
        this.COq = WR(i2);
        if (this.COr != null) {
            for (int i3 = 0; i3 < this.COr.size(); i3++) {
                SelectScanModeGrid.a aVar = (SelectScanModeGrid.a) this.COr.get(i3).getAdapter();
                if (aVar != null) {
                    for (int i4 = 0; i4 < aVar.getCount(); i4++) {
                        SelectScanModeGrid.b bVar = (SelectScanModeGrid.b) aVar.getItem(i4);
                        if (!(bVar == null || bVar.COj == null)) {
                            if (bVar.COi == i2) {
                                bVar.COj.setBackgroundResource(bVar.COh);
                                bVar.COk = false;
                                if (i3 > 0) {
                                    this.COD.setToScreen(i3);
                                    this.COE.setSelectedDot(i3);
                                }
                            } else {
                                bVar.COj.setBackgroundResource(bVar.COg);
                            }
                        }
                    }
                    aVar.COe = this.COq;
                    aVar.notifyDataSetChanged();
                }
            }
        }
        AppMethodBeat.o(51992);
    }

    private int WR(int i2) {
        for (int i3 = 0; i3 < this.COv.length; i3++) {
            if (this.COv[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    private void eRo() {
        int i2 = 1;
        AppMethodBeat.i(51993);
        if (this.COy == null) {
            this.COy = new AdapterView.OnItemClickListener() {
                /* class com.tencent.mm.plugin.scanner.ui.SelectScanModePanel.AnonymousClass3 */

                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    boolean z = true;
                    AppMethodBeat.i(51988);
                    b bVar = new b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    if (adapterView == null || SelectScanModePanel.this.context == null) {
                        StringBuilder append = new StringBuilder("parent == null ? ").append(adapterView == null).append(", context == null ? ");
                        if (SelectScanModePanel.this.context != null) {
                            z = false;
                        }
                        Log.e("MicroMsg.scanner.SelectScanModePanel", append.append(z).toString());
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(51988);
                        return;
                    }
                    SelectScanModeGrid.b bVar2 = (SelectScanModeGrid.b) adapterView.getAdapter().getItem(i2);
                    if (bVar2 == null) {
                        Log.e("MicroMsg.scanner.SelectScanModePanel", "clickItem == null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(51988);
                        return;
                    }
                    ((SelectScanModeGrid.a) adapterView.getAdapter()).COe = i2;
                    Log.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", Integer.valueOf(i2), bVar2.title);
                    if (!(SelectScanModePanel.this.COF == null || bVar2 == null)) {
                        a unused = SelectScanModePanel.this.COF;
                    }
                    SelectScanModePanel.this.setSelectedMode(bVar2.COi);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/SelectScanModePanel$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(51988);
                }
            };
        }
        this.COr = new ArrayList();
        if (this.COB == 0 || this.COC == 0) {
            AppMethodBeat.o(51993);
            return;
        }
        this.COD.removeAllViews();
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 64.0f);
        int fromDPToPix2 = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.context, 78.0f);
        int i3 = this.COB / fromDPToPix;
        int i4 = this.COC / fromDPToPix2;
        if (i3 == 0) {
            i3 = 1;
        } else if (i3 > this.COw.size()) {
            i3 = this.COw.size();
        }
        if (i4 != 0) {
            i2 = i4;
        }
        int i5 = i3 * i2;
        this.COz = 0;
        int i6 = this.COo;
        while (i6 > 0) {
            i6 -= i5;
            this.COz++;
        }
        for (int i7 = 0; i7 < this.COz; i7++) {
            ArrayList arrayList = new ArrayList();
            int i8 = i7 * i5;
            int i9 = i8;
            while (i9 < this.COw.size() && i9 < i8 + i5) {
                int WR = WR(this.COw.get(i9).intValue());
                arrayList.add(new SelectScanModeGrid.b(this.COs[WR], this.COt[WR], this.COu[WR], this.COw.get(i9).intValue(), this.COx.contains(this.COw.get(i9))));
                i9++;
            }
            if (arrayList.size() > 0) {
                SelectScanModeGrid selectScanModeGrid = (SelectScanModeGrid) inflate(this.context, R.layout.bpw, null);
                selectScanModeGrid.setNumColumns(i5);
                SelectScanModeGrid.a aVar = new SelectScanModeGrid.a(this.context, arrayList);
                aVar.COe = this.COq;
                selectScanModeGrid.setAdapter((ListAdapter) aVar);
                this.COD.addView(selectScanModeGrid, new LinearLayout.LayoutParams(-1, -1));
                selectScanModeGrid.setOnItemClickListener(this.COy);
                this.COr.add(selectScanModeGrid);
            }
        }
        eRp();
        AppMethodBeat.o(51993);
    }

    private void eRp() {
        AppMethodBeat.i(51994);
        if (this.COr.size() <= 1) {
            this.COE.setVisibility(4);
            AppMethodBeat.o(51994);
            return;
        }
        this.COE.setVisibility(0);
        this.COE.setDotCount(this.COr.size());
        int curScreen = this.COD.getCurScreen();
        this.COD.setToScreen(curScreen);
        this.COE.setSelectedDot(curScreen);
        AppMethodBeat.o(51994);
    }
}
