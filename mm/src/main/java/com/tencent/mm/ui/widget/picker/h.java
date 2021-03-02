package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.widget.picker.a.b;
import com.tencent.mm.ui.widget.picker.a.d;
import com.tencent.mm.ui.widget.picker.a.f;
import com.tencent.mm.ui.widget.picker.c.a;
import com.tencent.mm.ui.widget.picker.d.c;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

public final class h extends a implements View.OnClickListener {
    j QTy;
    boolean QTz = false;
    private String TAG = "TimePickerView";
    private Context context;

    public h(Context context2) {
        super(context2);
        AppMethodBeat.i(198443);
        this.QTy = new j(context2);
        this.context = context2;
        AppMethodBeat.o(198443);
    }

    public final void a(a aVar) {
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        AppMethodBeat.i(198444);
        this.QSH = aVar;
        Context context2 = aVar.context;
        ble();
        blb();
        blc();
        LayoutInflater.from(context2).inflate(R.layout.bi8, this.jLx);
        TextView textView = (TextView) findViewById(R.id.iwe);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.h_3);
        Button button = (Button) findViewById(R.id.aei);
        Button button2 = (Button) findViewById(R.id.aec);
        button.setTag("submit");
        button2.setTag("cancel");
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button.setText(TextUtils.isEmpty(this.QSH.jLj) ? context2.getResources().getString(R.string.fmy) : this.QSH.jLj);
        button2.setText(TextUtils.isEmpty(this.QSH.jLk) ? context2.getResources().getString(R.string.fms) : this.QSH.jLk);
        if (TextUtils.isEmpty(this.QSH.jLl)) {
            str = "";
        } else {
            str = this.QSH.jLl;
        }
        textView.setText(str);
        button.setTextColor(this.QSH.jLm);
        button2.setTextColor(this.QSH.jLn);
        textView.setTextColor(this.QSH.jLo);
        relativeLayout.setBackgroundColor(this.QSH.jLq);
        button.setTextSize((float) this.QSH.jLr);
        button2.setTextSize((float) this.QSH.jLr);
        textView.setTextSize((float) this.QSH.jLs);
        j jVar = this.QTy;
        boolean[] zArr = this.QSH.jKX;
        int i9 = this.QSH.jLi;
        if (jVar.view == null) {
            jVar.view = null;
        }
        jVar.jKX = zArr;
        jVar.gravity = i9;
        if (this.QSH.QUB != null) {
            this.QTy.QTN = new com.tencent.mm.ui.widget.picker.d.a() {
                /* class com.tencent.mm.ui.widget.picker.h.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.picker.d.a
                public final void bla() {
                    AppMethodBeat.i(198442);
                    try {
                        j.dateFormat.parse(h.this.QTy.getTime());
                        h.this.QSH.QUB.hce();
                        AppMethodBeat.o(198442);
                    } catch (ParseException e2) {
                        as.printErrStackTrace(h.this.TAG, e2, "", new Object[0]);
                        AppMethodBeat.o(198442);
                    }
                }
            };
        }
        if (!(this.QSH.startYear == 0 || this.QSH.endYear == 0 || this.QSH.startYear > this.QSH.endYear)) {
            this.QTy.startYear = this.QSH.startYear;
            this.QTy.endYear = this.QSH.endYear;
        }
        if (this.QSH.jKZ == null || this.QSH.jLa == null) {
            if (this.QSH.jKZ != null) {
                if (this.QSH.jKZ.get(1) < 1900) {
                    as.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null", new Object[0]);
                    this.QSH.jKZ = null;
                }
            } else if (this.QSH.jLa != null && this.QSH.jLa.get(1) > 2100) {
                as.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null", new Object[0]);
                this.QSH.jKZ = null;
            }
        } else if (this.QSH.jKZ.getTimeInMillis() > this.QSH.jLa.getTimeInMillis()) {
            as.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null", new Object[0]);
            this.QSH.jKZ = null;
        }
        j jVar2 = this.QTy;
        Calendar calendar = this.QSH.jKZ;
        Calendar calendar2 = this.QSH.jLa;
        if (calendar == null && calendar2 != null) {
            int i10 = calendar2.get(1);
            int i11 = calendar2.get(2) + 1;
            int i12 = calendar2.get(5);
            if (i10 > jVar2.startYear) {
                jVar2.endYear = i10;
                jVar2.jLX = i11;
                jVar2.jLZ = i12;
            } else if (i10 == jVar2.startYear) {
                if (i11 > jVar2.jLW) {
                    jVar2.endYear = i10;
                    jVar2.jLX = i11;
                    jVar2.jLZ = i12;
                } else if (i11 == jVar2.jLW && i12 > jVar2.jLY) {
                    jVar2.endYear = i10;
                    jVar2.jLX = i11;
                    jVar2.jLZ = i12;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i13 = calendar.get(1);
            int i14 = calendar.get(2) + 1;
            int i15 = calendar.get(5);
            if (i13 < jVar2.endYear) {
                jVar2.jLW = i14;
                jVar2.jLY = i15;
                jVar2.startYear = i13;
            } else if (i13 == jVar2.endYear) {
                if (i14 < jVar2.jLX) {
                    jVar2.jLW = i14;
                    jVar2.jLY = i15;
                    jVar2.startYear = i13;
                } else if (i14 == jVar2.jLX && i15 < jVar2.jLZ) {
                    jVar2.jLW = i14;
                    jVar2.jLY = i15;
                    jVar2.startYear = i13;
                }
            }
        } else if (!(calendar == null || calendar2 == null)) {
            jVar2.startYear = calendar.get(1);
            jVar2.endYear = calendar2.get(1);
            jVar2.jLW = calendar.get(2) + 1;
            jVar2.jLX = calendar2.get(2) + 1;
            jVar2.jLY = calendar.get(5);
            jVar2.jLZ = calendar2.get(5);
            jVar2.jMa = calendar.get(11);
            jVar2.jMb = calendar.get(12);
            jVar2.jMc = calendar2.get(11);
            jVar2.jMd = calendar2.get(12);
        }
        if (!this.QTz) {
            if (this.QSH.jKZ == null || this.QSH.jLa == null) {
                if (this.QSH.jKZ != null) {
                    this.QSH.jKY = this.QSH.jKZ;
                } else if (this.QSH.jLa != null) {
                    this.QSH.jKY = this.QSH.jLa;
                }
            } else if (this.QSH.jKY == null || this.QSH.jKY.getTimeInMillis() < this.QSH.jKZ.getTimeInMillis()) {
                this.QSH.jKY = this.QSH.jKZ;
            } else if (this.QSH.jKY.getTimeInMillis() > this.QSH.jLa.getTimeInMillis()) {
                this.QSH.jKY = this.QSH.jLa;
            }
        }
        if (this.QSH.jKY == null) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(System.currentTimeMillis());
            i2 = instance.get(1);
            i3 = instance.get(2);
            i4 = instance.get(5);
            i5 = instance.get(11);
            i6 = instance.get(12);
            i7 = instance.get(13);
        } else {
            i2 = this.QSH.jKY.get(1);
            i3 = this.QSH.jKY.get(2);
            i4 = this.QSH.jKY.get(5);
            i5 = this.QSH.jKY.get(11);
            i6 = this.QSH.jKY.get(12);
            i7 = this.QSH.jKY.get(13);
        }
        j jVar3 = this.QTy;
        jVar3.jMe = i2;
        jVar3.QTE = (WheelView) jVar3.view.findViewById(R.id.jsl);
        jVar3.QTF = (WheelView) jVar3.view.findViewById(R.id.fjl);
        jVar3.QTG = (WheelView) jVar3.view.findViewById(R.id.bkr);
        jVar3.QTK = new f(jVar3.startYear, jVar3.endYear, jVar3.ctx);
        jVar3.QTE.setAdapter(jVar3.QTK);
        jVar3.QTE.setCurrentItem(i2 - jVar3.startYear);
        jVar3.QTE.setGravity(jVar3.gravity);
        if (jVar3.startYear == jVar3.endYear) {
            jVar3.QTF.setAdapter(new d(jVar3.jLW, jVar3.jLX, new b(jVar3.ctx)));
            jVar3.QTF.setCurrentItem((i3 + 1) - jVar3.jLW);
        } else if (i2 == jVar3.startYear) {
            jVar3.QTF.setAdapter(new d(jVar3.jLW, 12, new b(jVar3.ctx)));
            jVar3.QTF.setCurrentItem((i3 + 1) - jVar3.jLW);
        } else if (i2 == jVar3.endYear) {
            jVar3.QTF.setAdapter(new d(1, jVar3.jLX, new b(jVar3.ctx)));
            jVar3.QTF.setCurrentItem(i3);
        } else if (!jVar3.QTL || i2 - 1 != jVar3.startYear) {
            jVar3.QTF.setAdapter(new d(1, 12, new b(jVar3.ctx)));
            jVar3.QTF.setCurrentItem(i3);
        } else {
            jVar3.QTF.setAdapter(new d(jVar3.jLW, 12, new b(jVar3.ctx)));
            jVar3.QTF.setCurrentItem((i3 + 1) - jVar3.jLW);
        }
        jVar3.QTF.setGravity(jVar3.gravity);
        if (jVar3.QTL) {
            i8 = i2 - 1;
        } else {
            i8 = i2;
        }
        if (jVar3.startYear == jVar3.endYear && jVar3.jLW == jVar3.jLX) {
            if (jVar3.jMi.contains(String.valueOf(i3 + 1))) {
                if (jVar3.jLZ > 31) {
                    jVar3.jLZ = 31;
                }
                jVar3.QTG.setAdapter(new d(jVar3.jLY, jVar3.jLZ));
            } else if (jVar3.jMj.contains(String.valueOf(i3 + 1))) {
                if (jVar3.jLZ > 30) {
                    jVar3.jLZ = 30;
                }
                jVar3.QTG.setAdapter(new d(jVar3.jLY, jVar3.jLZ));
            } else if ((i8 % 4 != 0 || i8 % 100 == 0) && i8 % 400 != 0) {
                if (jVar3.jLZ > 28) {
                    jVar3.jLZ = 28;
                }
                jVar3.QTG.setAdapter(new d(jVar3.jLY, jVar3.jLZ));
            } else {
                if (jVar3.jLZ > 29) {
                    jVar3.jLZ = 29;
                }
                jVar3.QTG.setAdapter(new d(jVar3.jLY, jVar3.jLZ));
            }
            jVar3.QTG.setCurrentItem(i4 - jVar3.jLY);
        } else if (i8 == jVar3.startYear && i3 + 1 == jVar3.jLW) {
            if (jVar3.jMi.contains(String.valueOf(i3 + 1))) {
                jVar3.QTG.setAdapter(new d(jVar3.jLY, 31));
            } else if (jVar3.jMj.contains(String.valueOf(i3 + 1))) {
                jVar3.QTG.setAdapter(new d(jVar3.jLY, 30));
            } else if ((i8 % 4 != 0 || i8 % 100 == 0) && i8 % 400 != 0) {
                jVar3.QTG.setAdapter(new d(jVar3.jLY, 28));
            } else {
                jVar3.QTG.setAdapter(new d(jVar3.jLY, 29));
            }
            jVar3.QTG.setCurrentItem(i4 - jVar3.jLY);
        } else if (i8 == jVar3.endYear && i3 + 1 == jVar3.jLX) {
            if (jVar3.jMi.contains(String.valueOf(i3 + 1))) {
                if (jVar3.jLZ > 31) {
                    jVar3.jLZ = 31;
                }
                jVar3.QTG.setAdapter(new d(1, jVar3.jLZ));
            } else if (jVar3.jMj.contains(String.valueOf(i3 + 1))) {
                if (jVar3.jLZ > 30) {
                    jVar3.jLZ = 30;
                }
                jVar3.QTG.setAdapter(new d(1, jVar3.jLZ));
            } else if ((i8 % 4 != 0 || i8 % 100 == 0) && i8 % 400 != 0) {
                if (jVar3.jLZ > 28) {
                    jVar3.jLZ = 28;
                }
                jVar3.QTG.setAdapter(new d(1, jVar3.jLZ));
            } else {
                if (jVar3.jLZ > 29) {
                    jVar3.jLZ = 29;
                }
                jVar3.QTG.setAdapter(new d(1, jVar3.jLZ));
            }
            jVar3.QTG.setCurrentItem(i4 - 1);
        } else {
            if (jVar3.jMi.contains(String.valueOf(i3 + 1))) {
                jVar3.QTG.setAdapter(new d(1, 31));
            } else if (jVar3.jMj.contains(String.valueOf(i3 + 1))) {
                jVar3.QTG.setAdapter(new d(1, 30));
            } else if ((i8 % 4 != 0 || i8 % 100 == 0) && i8 % 400 != 0) {
                jVar3.QTG.setAdapter(new d(1, 28));
            } else {
                jVar3.QTG.setAdapter(new d(1, 29));
            }
            jVar3.QTG.setCurrentItem(i4 - 1);
        }
        jVar3.QTG.setGravity(jVar3.gravity);
        jVar3.QTH = (WheelView) jVar3.view.findViewById(R.id.dq7);
        jVar3.QTH.setAdapter(new d(jVar3.jMa, jVar3.jMc));
        jVar3.QTH.setCurrentItem(i5 - jVar3.jMa);
        jVar3.QTH.setGravity(jVar3.gravity);
        jVar3.QTI = (WheelView) jVar3.view.findViewById(R.id.fel);
        if (i5 == jVar3.jMa && jVar3.jMa == jVar3.jMc) {
            jVar3.QTI.setAdapter(new d(jVar3.jMb, jVar3.jMd));
            if (i6 < jVar3.jMb) {
                jVar3.QTI.setCurrentItem(0);
            } else if (i6 > jVar3.jMd) {
                jVar3.QTI.setCurrentItem(jVar3.jMd);
            } else {
                jVar3.QTI.setCurrentItem(i6);
            }
        } else if (i5 == jVar3.jMa) {
            jVar3.QTI.setAdapter(new d(jVar3.jMb, 59));
            if (i6 < jVar3.jMb) {
                jVar3.QTI.setCurrentItem(0);
            } else {
                jVar3.QTI.setCurrentItem(i6 - jVar3.jMb);
            }
        } else if (i5 == jVar3.jMc) {
            jVar3.QTI.setAdapter(new d(0, jVar3.jMd));
            if (i6 >= jVar3.jMd) {
                jVar3.QTI.setCurrentItem(jVar3.jMd);
            } else {
                jVar3.QTI.setCurrentItem(i6);
            }
        } else {
            jVar3.QTI.setAdapter(new d(0, 59));
            jVar3.QTI.setCurrentItem(i6);
        }
        jVar3.QTI.setGravity(jVar3.gravity);
        jVar3.QTJ = (WheelView) jVar3.view.findViewById(R.id.hfb);
        jVar3.QTJ.setAdapter(new d(0, 59));
        jVar3.QTJ.setCurrentItem(i7);
        jVar3.QTJ.setGravity(jVar3.gravity);
        jVar3.QTH.setOnItemSelectedListener(new c() {
            /* class com.tencent.mm.ui.widget.picker.j.AnonymousClass3 */
            private int jMl;

            @Override // com.tencent.mm.ui.widget.picker.d.c
            public final void onItemSelected(int i2) {
                AppMethodBeat.i(198453);
                int intValue = ((Integer) j.this.QTH.getAdapter().getItem(i2)).intValue();
                this.jMl = ((Integer) j.this.QTI.getAdapter().getItem(j.this.QTI.getCurrentItem())).intValue();
                if (intValue == j.this.jMc) {
                    j.this.QTI.setAdapter(new d(0, j.this.jMd));
                    if (this.jMl >= j.this.jMd) {
                        j.this.QTI.setCurrentItem(j.this.jMd);
                    } else {
                        j.this.QTI.setCurrentItem(this.jMl);
                    }
                } else if (intValue == j.this.jMa) {
                    j.this.QTI.setAdapter(new d(j.this.jMb, 59));
                    if (this.jMl < j.this.jMb) {
                        j.this.QTI.setCurrentItem(0);
                    } else {
                        j.this.QTI.setCurrentItem(this.jMl - j.this.jMb);
                    }
                } else {
                    j.this.QTI.setAdapter(new d(0, 59));
                    j.this.QTI.setCurrentItem(this.jMl);
                }
                if (j.this.QTN != null) {
                    j.this.QTN.bla();
                }
                AppMethodBeat.o(198453);
            }
        });
        jVar3.QTE.setOnItemSelectedListener(new c() {
            /* class com.tencent.mm.ui.widget.picker.j.AnonymousClass2 */

            @Override // com.tencent.mm.ui.widget.picker.d.c
            public final void onItemSelected(int i2) {
                AppMethodBeat.i(198452);
                int i3 = i2 + j.this.startYear;
                if (j.this.QTL) {
                    i3--;
                }
                int intValue = ((Integer) j.this.QTF.getAdapter().getItem(j.this.QTF.getCurrentItem())).intValue();
                j.this.jMe = i3;
                if (!j.this.QTL || i2 != -1) {
                    j.this.QTF.aps(android.support.v4.content.b.n(j.this.ctx, R.color.BW_0_Alpha_0_9));
                    j.this.QTG.aps(android.support.v4.content.b.n(j.this.ctx, R.color.BW_0_Alpha_0_9));
                    j.this.QTF.invalidate();
                    j.this.QTG.invalidate();
                    int currentItem = j.this.QTF.getCurrentItem();
                    if (j.this.startYear == j.this.endYear) {
                        j.this.QTF.setAdapter(new d(j.this.jLW, j.this.jLX, new b(j.this.ctx)));
                        if (currentItem > j.this.QTF.getAdapter().getItemsCount() - 1) {
                            currentItem = j.this.QTF.getAdapter().getItemsCount() - 1;
                            j.this.QTF.setCurrentItem(currentItem);
                        }
                        int i4 = j.this.jLW + currentItem;
                        if (j.this.jLW == j.this.jLX) {
                            j.a(j.this, i3, i4, j.this.jLY, j.this.jLZ, j.this.jMi, j.this.jMj);
                        } else if (i4 == j.this.jLW) {
                            j.a(j.this, i3, i4, j.this.jLY, 31, j.this.jMi, j.this.jMj);
                        } else if (i4 == j.this.jLX) {
                            j.a(j.this, i3, i4, 1, j.this.jLZ, j.this.jMi, j.this.jMj);
                        } else {
                            j.a(j.this, i3, i4, 1, 31, j.this.jMi, j.this.jMj);
                        }
                    } else if (i3 == j.this.startYear) {
                        j.this.QTF.setAdapter(new d(j.this.jLW, 12, new b(j.this.ctx)));
                        if (intValue <= j.this.jLW) {
                            j.this.QTF.setCurrentItem(0);
                            intValue = j.this.jLW;
                        } else {
                            j.this.QTF.setCurrentItem(intValue - j.this.jLW);
                        }
                        if (intValue == j.this.jLW) {
                            j.a(j.this, i3, intValue, j.this.jLY, 31, j.this.jMi, j.this.jMj);
                        } else {
                            j.a(j.this, i3, intValue, 1, 31, j.this.jMi, j.this.jMj);
                        }
                    } else if (i3 == j.this.endYear) {
                        j.this.QTF.setAdapter(new d(1, j.this.jLX, new b(j.this.ctx)));
                        if (currentItem > j.this.QTF.getAdapter().getItemsCount() - 1) {
                            currentItem = j.this.QTF.getAdapter().getItemsCount() - 1;
                            j.this.QTF.setCurrentItem(currentItem);
                        }
                        if (intValue >= j.this.jLX) {
                            j.this.QTF.setCurrentItem(j.this.jLX - 1);
                        } else {
                            j.this.QTF.setCurrentItem(intValue - 1);
                        }
                        int i5 = currentItem + 1;
                        if (i5 == j.this.jLX) {
                            j.a(j.this, i3, i5, 1, j.this.jLZ, j.this.jMi, j.this.jMj);
                        } else {
                            j.a(j.this, i3, i5, 1, 31, j.this.jMi, j.this.jMj);
                        }
                    } else {
                        j.this.QTF.setAdapter(new d(1, 12, new b(j.this.ctx)));
                        j.this.QTF.setCurrentItem(intValue - 1);
                        j jVar = j.this;
                        j.a(jVar, i3, jVar.QTF.getCurrentItem() + 1, 1, 31, j.this.jMi, j.this.jMj);
                    }
                } else {
                    j.this.QTF.aps(0);
                    j.this.QTG.aps(0);
                    j.this.QTF.invalidate();
                    j.this.QTG.invalidate();
                }
                if (j.this.QTN != null) {
                    j.this.QTN.bla();
                }
                AppMethodBeat.o(198452);
            }
        });
        jVar3.QTF.setOnItemSelectedListener(new c() {
            /* class com.tencent.mm.ui.widget.picker.j.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.picker.d.c
            public final void onItemSelected(int i2) {
                AppMethodBeat.i(198451);
                int i3 = i2 + 1;
                if (j.this.startYear == j.this.endYear) {
                    int i4 = (j.this.jLW + i3) - 1;
                    if (j.this.jLW == j.this.jLX) {
                        j.a(j.this, j.this.jMe, i4, j.this.jLY, j.this.jLZ, j.this.jMi, j.this.jMj);
                    } else if (j.this.jLW == i4) {
                        j.a(j.this, j.this.jMe, i4, j.this.jLY, 31, j.this.jMi, j.this.jMj);
                    } else if (j.this.jLX == i4) {
                        j.a(j.this, j.this.jMe, i4, 1, j.this.jLZ, j.this.jMi, j.this.jMj);
                    } else {
                        j.a(j.this, j.this.jMe, i4, 1, 31, j.this.jMi, j.this.jMj);
                    }
                } else if (j.this.jMe == j.this.startYear) {
                    int i5 = (j.this.jLW + i3) - 1;
                    if (i5 == j.this.jLW) {
                        j.a(j.this, j.this.jMe, i5, j.this.jLY, 31, j.this.jMi, j.this.jMj);
                    } else {
                        j.a(j.this, j.this.jMe, i5, 1, 31, j.this.jMi, j.this.jMj);
                    }
                } else if (j.this.jMe != j.this.endYear) {
                    j.a(j.this, j.this.jMe, i3, 1, 31, j.this.jMi, j.this.jMj);
                } else if (i3 == j.this.jLX) {
                    j.a(j.this, j.this.jMe, j.this.QTF.getCurrentItem() + 1, 1, j.this.jLZ, j.this.jMi, j.this.jMj);
                } else {
                    j.a(j.this, j.this.jMe, j.this.QTF.getCurrentItem() + 1, 1, 31, j.this.jMi, j.this.jMj);
                }
                if (j.this.QTN != null) {
                    j.this.QTN.bla();
                }
                AppMethodBeat.o(198451);
            }
        });
        jVar3.a(jVar3.QTG);
        jVar3.a(jVar3.QTH);
        jVar3.a(jVar3.QTI);
        jVar3.a(jVar3.QTJ);
        if (jVar3.jKX.length != 6) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("type[] length is not 6");
            AppMethodBeat.o(198444);
            throw illegalArgumentException;
        }
        j.aP(jVar3.bll());
        if (jVar3.QTL && i2 == 2) {
            jVar3.QTF.aps(0);
            jVar3.QTG.aps(0);
            jVar3.QTF.invalidate();
            jVar3.QTG.invalidate();
        }
        if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh")) {
            j jVar4 = this.QTy;
            String str2 = this.QSH.jLb;
            String str3 = this.QSH.jLc;
            String str4 = this.QSH.jLd;
            String str5 = this.QSH.jLe;
            String str6 = this.QSH.jLf;
            String str7 = this.QSH.jLg;
            if (str2 != null) {
                jVar4.QTE.setLabel(str2);
            } else {
                jVar4.QTE.setLabel(jVar4.view.getContext().getString(R.string.fmz));
            }
            if (str3 != null) {
                jVar4.QTF.setLabel(str3);
            } else {
                jVar4.QTF.setLabel(jVar4.view.getContext().getString(R.string.fmw));
            }
            if (str4 != null) {
                jVar4.QTG.setLabel(str4);
            } else {
                jVar4.QTG.setLabel(jVar4.view.getContext().getString(R.string.fmt));
            }
            if (str5 != null) {
                jVar4.QTH.setLabel(str5);
            } else {
                jVar4.QTH.setLabel(jVar4.view.getContext().getString(R.string.fmu));
            }
            if (str6 != null) {
                jVar4.QTI.setLabel(str6);
            } else {
                jVar4.QTI.setLabel(jVar4.view.getContext().getString(R.string.fmv));
            }
            if (str7 != null) {
                jVar4.QTJ.setLabel(str7);
            } else {
                jVar4.QTJ.setLabel(jVar4.view.getContext().getString(R.string.fmx));
            }
        }
        Ds(this.QSH.ox);
        this.QTy.setDividerColor(this.QSH.jKu);
        this.QTy.QTM = this.QSH.QTM;
        j jVar5 = this.QTy;
        boolean z = this.QSH.jKV;
        jVar5.QTE.setCyclic(z);
        jVar5.QTF.setCyclic(z);
        jVar5.QTG.setCyclic(z);
        jVar5.QTH.setCyclic(z);
        jVar5.QTI.setCyclic(z);
        jVar5.QTJ.setCyclic(z);
        this.QTy.jLu = this.QSH.jLu;
        j jVar6 = this.QTy;
        boolean z2 = this.QSH.jKn;
        jVar6.QTG.jKn = z2;
        jVar6.QTF.jKn = z2;
        jVar6.QTE.jKn = z2;
        jVar6.QTH.jKn = z2;
        jVar6.QTI.jKn = z2;
        jVar6.QTJ.jKn = z2;
        AppMethodBeat.o(198444);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(198445);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (((String) view.getTag()).equals("submit")) {
            blg();
        }
        dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198445);
    }

    public final void blg() {
        AppMethodBeat.i(198446);
        if (this.QSH.QUA != null) {
            try {
                this.QSH.QUA.a(j.dateFormat.parse(this.QTy.getTime()));
                AppMethodBeat.o(198446);
                return;
            } catch (ParseException e2) {
                as.printErrStackTrace(this.TAG, e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(198446);
    }

    public final View bli() {
        AppMethodBeat.i(198447);
        if (this.QTy.view == null) {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.bi8, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.inp);
            ((ViewGroup) inflate).removeView(linearLayout);
            linearLayout.setBackgroundColor(-1);
            this.QTy.view = linearLayout;
        }
        View view = this.QTy.view;
        AppMethodBeat.o(198447);
        return view;
    }

    @Override // com.tencent.mm.ui.widget.picker.a
    public final boolean blf() {
        return this.QSH.jLv;
    }

    public final void setDividerHeight(float f2) {
        AppMethodBeat.i(198448);
        if (this.QTy != null) {
            this.QTy.setDividerHeight(f2);
        }
        AppMethodBeat.o(198448);
    }

    public final void dE(int i2, int i3) {
        AppMethodBeat.i(198449);
        this.QTy.dE(i2, i3);
        AppMethodBeat.o(198449);
    }

    public final List<WheelView> hcm() {
        AppMethodBeat.i(258272);
        List<WheelView> bll = this.QTy.bll();
        AppMethodBeat.o(258272);
        return bll;
    }
}
