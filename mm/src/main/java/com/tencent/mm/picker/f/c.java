package com.tencent.mm.picker.f;

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
import com.tencent.mm.picker.a.b;
import com.tencent.mm.picker.a.c;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mm.picker.c.a;
import com.tencent.stubs.logger.Log;
import java.text.ParseException;
import java.util.Calendar;

public final class c extends a implements View.OnClickListener {
    private String TAG = "TimePickerView";
    private Context context;
    public e jLJ;

    public c(Context context2) {
        super(context2);
        AppMethodBeat.i(175353);
        this.jLJ = new e(context2);
        this.context = context2;
        AppMethodBeat.o(175353);
    }

    public final void b(a aVar) {
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        AppMethodBeat.i(175354);
        this.jKP = aVar;
        Context context2 = aVar.context;
        ble();
        blb();
        blc();
        LayoutInflater.from(context2).inflate(R.layout.bi7, this.jLx);
        TextView textView = (TextView) findViewById(R.id.iwe);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.h_3);
        Button button = (Button) findViewById(R.id.aei);
        Button button2 = (Button) findViewById(R.id.aec);
        button.setTag("submit");
        button2.setTag("cancel");
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button.setText(TextUtils.isEmpty(this.jKP.jLj) ? context2.getResources().getString(R.string.fmy) : this.jKP.jLj);
        button2.setText(TextUtils.isEmpty(this.jKP.jLk) ? context2.getResources().getString(R.string.fms) : this.jKP.jLk);
        if (TextUtils.isEmpty(this.jKP.jLl)) {
            str = "";
        } else {
            str = this.jKP.jLl;
        }
        textView.setText(str);
        button.setTextColor(this.jKP.jLm);
        button2.setTextColor(this.jKP.jLn);
        textView.setTextColor(this.jKP.jLo);
        relativeLayout.setBackgroundColor(this.jKP.jLq);
        button.setTextSize((float) this.jKP.jLr);
        button2.setTextSize((float) this.jKP.jLr);
        textView.setTextSize((float) this.jKP.jLs);
        e eVar = this.jLJ;
        boolean[] zArr = this.jKP.jKX;
        int i8 = this.jKP.jLi;
        if (eVar.view == null) {
            eVar.view = null;
        }
        eVar.jKX = zArr;
        eVar.gravity = i8;
        if (this.jKP.jKT != null) {
            this.jLJ.jMf = new com.tencent.mm.picker.d.a() {
                /* class com.tencent.mm.picker.f.c.AnonymousClass1 */

                @Override // com.tencent.mm.picker.d.a
                public final void bla() {
                    AppMethodBeat.i(175352);
                    try {
                        e.dateFormat.parse(c.this.jLJ.getTime());
                        AppMethodBeat.o(175352);
                    } catch (ParseException e2) {
                        Log.printStack(6, c.this.TAG, e2);
                        AppMethodBeat.o(175352);
                    }
                }
            };
        }
        if (!(this.jKP.startYear == 0 || this.jKP.endYear == 0 || this.jKP.startYear > this.jKP.endYear)) {
            this.jLJ.startYear = this.jKP.startYear;
            this.jLJ.endYear = this.jKP.endYear;
        }
        if (this.jKP.jKZ == null || this.jKP.jLa == null) {
            if (this.jKP.jKZ != null) {
                if (this.jKP.jKZ.get(1) < 1900) {
                    Log.e(this.TAG, "initWheelTime: The startDate can not as early as 1900, set startDate to null");
                    this.jKP.jKZ = null;
                }
            } else if (this.jKP.jLa != null && this.jKP.jLa.get(1) > 2100) {
                Log.e(this.TAG, "initWheelTime: The endDate should not be later than 2100, set endDate to null");
                this.jKP.jKZ = null;
            }
        } else if (this.jKP.jKZ.getTimeInMillis() > this.jKP.jLa.getTimeInMillis()) {
            Log.e(this.TAG, "initWheelTime: startDate can't be later than endDate, set startDate to null");
            this.jKP.jKZ = null;
        }
        e eVar2 = this.jLJ;
        Calendar calendar = this.jKP.jKZ;
        Calendar calendar2 = this.jKP.jLa;
        if (calendar == null && calendar2 != null) {
            int i9 = calendar2.get(1);
            int i10 = calendar2.get(2) + 1;
            int i11 = calendar2.get(5);
            if (i9 > eVar2.startYear) {
                eVar2.endYear = i9;
                eVar2.jLX = i10;
                eVar2.jLZ = i11;
            } else if (i9 == eVar2.startYear) {
                if (i10 > eVar2.jLW) {
                    eVar2.endYear = i9;
                    eVar2.jLX = i10;
                    eVar2.jLZ = i11;
                } else if (i10 == eVar2.jLW && i11 > eVar2.jLY) {
                    eVar2.endYear = i9;
                    eVar2.jLX = i10;
                    eVar2.jLZ = i11;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i12 = calendar.get(1);
            int i13 = calendar.get(2) + 1;
            int i14 = calendar.get(5);
            if (i12 < eVar2.endYear) {
                eVar2.jLW = i13;
                eVar2.jLY = i14;
                eVar2.startYear = i12;
            } else if (i12 == eVar2.endYear) {
                if (i13 < eVar2.jLX) {
                    eVar2.jLW = i13;
                    eVar2.jLY = i14;
                    eVar2.startYear = i12;
                } else if (i13 == eVar2.jLX && i14 < eVar2.jLZ) {
                    eVar2.jLW = i13;
                    eVar2.jLY = i14;
                    eVar2.startYear = i12;
                }
            }
        } else if (!(calendar == null || calendar2 == null)) {
            eVar2.startYear = calendar.get(1);
            eVar2.endYear = calendar2.get(1);
            eVar2.jLW = calendar.get(2) + 1;
            eVar2.jLX = calendar2.get(2) + 1;
            eVar2.jLY = calendar.get(5);
            eVar2.jLZ = calendar2.get(5);
            eVar2.jMa = calendar.get(11);
            eVar2.jMb = calendar.get(12);
            eVar2.jMc = calendar2.get(11);
            eVar2.jMd = calendar2.get(12);
        }
        if (this.jKP.jKZ == null || this.jKP.jLa == null) {
            if (this.jKP.jKZ != null) {
                this.jKP.jKY = this.jKP.jKZ;
            } else if (this.jKP.jLa != null) {
                this.jKP.jKY = this.jKP.jLa;
            }
        } else if (this.jKP.jKY == null || this.jKP.jKY.getTimeInMillis() < this.jKP.jKZ.getTimeInMillis()) {
            this.jKP.jKY = this.jKP.jKZ;
        } else if (this.jKP.jKY.getTimeInMillis() > this.jKP.jLa.getTimeInMillis()) {
            this.jKP.jKY = this.jKP.jLa;
        }
        if (this.jKP.jKY == null) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(System.currentTimeMillis());
            i2 = instance.get(1);
            i3 = instance.get(2);
            i4 = instance.get(5);
            i5 = instance.get(11);
            i6 = instance.get(12);
            i7 = instance.get(13);
        } else {
            i2 = this.jKP.jKY.get(1);
            i3 = this.jKP.jKY.get(2);
            i4 = this.jKP.jKY.get(5);
            i5 = this.jKP.jKY.get(11);
            i6 = this.jKP.jKY.get(12);
            i7 = this.jKP.jKY.get(13);
        }
        e eVar3 = this.jLJ;
        eVar3.jMe = i2;
        eVar3.jLQ = (WheelView) eVar3.view.findViewById(R.id.jsl);
        eVar3.jLQ.setAdapter(new com.tencent.mm.picker.a.c(eVar3.startYear, eVar3.endYear));
        eVar3.jLQ.setCurrentItem(i2 - eVar3.startYear);
        eVar3.jLQ.setGravity(eVar3.gravity);
        eVar3.jLR = (WheelView) eVar3.view.findViewById(R.id.fjl);
        if (eVar3.startYear == eVar3.endYear) {
            eVar3.jLR.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jLW, eVar3.jLX, new b(eVar3.ctx)));
            eVar3.jLR.setCurrentItem((i3 + 1) - eVar3.jLW);
        } else if (i2 == eVar3.startYear) {
            eVar3.jLR.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jLW, 12, new b(eVar3.ctx)));
            eVar3.jLR.setCurrentItem((i3 + 1) - eVar3.jLW);
        } else if (i2 == eVar3.endYear) {
            eVar3.jLR.setAdapter(new com.tencent.mm.picker.a.c(1, eVar3.jLX, new b(eVar3.ctx)));
            eVar3.jLR.setCurrentItem(i3);
        } else {
            eVar3.jLR.setAdapter(new com.tencent.mm.picker.a.c(1, 12, new b(eVar3.ctx)));
            eVar3.jLR.setCurrentItem(i3);
        }
        eVar3.jLR.setGravity(eVar3.gravity);
        eVar3.jLS = (WheelView) eVar3.view.findViewById(R.id.bkr);
        if (eVar3.startYear == eVar3.endYear && eVar3.jLW == eVar3.jLX) {
            if (eVar3.jMi.contains(String.valueOf(i3 + 1))) {
                if (eVar3.jLZ > 31) {
                    eVar3.jLZ = 31;
                }
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jLY, eVar3.jLZ));
            } else if (eVar3.jMj.contains(String.valueOf(i3 + 1))) {
                if (eVar3.jLZ > 30) {
                    eVar3.jLZ = 30;
                }
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jLY, eVar3.jLZ));
            } else if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
                if (eVar3.jLZ > 28) {
                    eVar3.jLZ = 28;
                }
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jLY, eVar3.jLZ));
            } else {
                if (eVar3.jLZ > 29) {
                    eVar3.jLZ = 29;
                }
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jLY, eVar3.jLZ));
            }
            eVar3.jLS.setCurrentItem(i4 - eVar3.jLY);
        } else if (i2 == eVar3.startYear && i3 + 1 == eVar3.jLW) {
            if (eVar3.jMi.contains(String.valueOf(i3 + 1))) {
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jLY, 31));
            } else if (eVar3.jMj.contains(String.valueOf(i3 + 1))) {
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jLY, 30));
            } else if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jLY, 28));
            } else {
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jLY, 29));
            }
            eVar3.jLS.setCurrentItem(i4 - eVar3.jLY);
        } else if (i2 == eVar3.endYear && i3 + 1 == eVar3.jLX) {
            if (eVar3.jMi.contains(String.valueOf(i3 + 1))) {
                if (eVar3.jLZ > 31) {
                    eVar3.jLZ = 31;
                }
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, eVar3.jLZ));
            } else if (eVar3.jMj.contains(String.valueOf(i3 + 1))) {
                if (eVar3.jLZ > 30) {
                    eVar3.jLZ = 30;
                }
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, eVar3.jLZ));
            } else if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
                if (eVar3.jLZ > 28) {
                    eVar3.jLZ = 28;
                }
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, eVar3.jLZ));
            } else {
                if (eVar3.jLZ > 29) {
                    eVar3.jLZ = 29;
                }
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, eVar3.jLZ));
            }
            eVar3.jLS.setCurrentItem(i4 - 1);
        } else {
            if (eVar3.jMi.contains(String.valueOf(i3 + 1))) {
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, 31));
            } else if (eVar3.jMj.contains(String.valueOf(i3 + 1))) {
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, 30));
            } else if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, 28));
            } else {
                eVar3.jLS.setAdapter(new com.tencent.mm.picker.a.c(1, 29));
            }
            eVar3.jLS.setCurrentItem(i4 - 1);
        }
        eVar3.jLS.setGravity(eVar3.gravity);
        eVar3.jLT = (WheelView) eVar3.view.findViewById(R.id.dq7);
        eVar3.jLT.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jMa, eVar3.jMc));
        eVar3.jLT.setCurrentItem(i5 - eVar3.jMa);
        eVar3.jLT.setGravity(eVar3.gravity);
        eVar3.jLU = (WheelView) eVar3.view.findViewById(R.id.fel);
        if (i5 == eVar3.jMa && eVar3.jMa == eVar3.jMc) {
            eVar3.jLU.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jMb, eVar3.jMd));
            if (i6 < eVar3.jMb) {
                eVar3.jLU.setCurrentItem(0);
            } else if (i6 > eVar3.jMd) {
                eVar3.jLU.setCurrentItem(eVar3.jMd);
            } else {
                eVar3.jLU.setCurrentItem(i6);
            }
        } else if (i5 == eVar3.jMa) {
            eVar3.jLU.setAdapter(new com.tencent.mm.picker.a.c(eVar3.jMb, 59));
            if (i6 < eVar3.jMb) {
                eVar3.jLU.setCurrentItem(0);
            } else {
                eVar3.jLU.setCurrentItem(i6 - eVar3.jMb);
            }
        } else if (i5 == eVar3.jMc) {
            eVar3.jLU.setAdapter(new com.tencent.mm.picker.a.c(0, eVar3.jMd));
            if (i6 >= eVar3.jMd) {
                eVar3.jLU.setCurrentItem(eVar3.jMd);
            } else {
                eVar3.jLU.setCurrentItem(i6);
            }
        } else {
            eVar3.jLU.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
            eVar3.jLU.setCurrentItem(i6);
        }
        eVar3.jLU.setGravity(eVar3.gravity);
        eVar3.jLV = (WheelView) eVar3.view.findViewById(R.id.hfb);
        eVar3.jLV.setAdapter(new com.tencent.mm.picker.a.c(0, 59));
        eVar3.jLV.setCurrentItem(i7);
        eVar3.jLV.setGravity(eVar3.gravity);
        eVar3.jLT.setOnItemSelectedListener(new com.tencent.mm.picker.base.b.b() {
            /* class com.tencent.mm.picker.f.e.AnonymousClass3 */
            private int jMl;

            @Override // com.tencent.mm.picker.base.b.b
            public final void onItemSelected(int i2) {
                AppMethodBeat.i(175369);
                int intValue = ((Integer) e.this.jLT.getAdapter().getItem(i2)).intValue();
                this.jMl = ((Integer) e.this.jLU.getAdapter().getItem(e.this.jLU.getCurrentItem())).intValue();
                if (intValue == e.this.jMc) {
                    e.this.jLU.setAdapter(new c(0, e.this.jMd));
                    if (this.jMl >= e.this.jMd) {
                        e.this.jLU.setCurrentItem(e.this.jMd);
                    } else {
                        e.this.jLU.setCurrentItem(this.jMl);
                    }
                } else if (intValue == e.this.jMa) {
                    e.this.jLU.setAdapter(new c(e.this.jMb, 59));
                    if (this.jMl < e.this.jMb) {
                        e.this.jLU.setCurrentItem(0);
                    } else {
                        e.this.jLU.setCurrentItem(this.jMl - e.this.jMb);
                    }
                } else {
                    e.this.jLU.setAdapter(new c(0, 59));
                    e.this.jLU.setCurrentItem(this.jMl);
                }
                if (e.this.jMf != null) {
                    e.this.jMf.bla();
                }
                AppMethodBeat.o(175369);
            }
        });
        eVar3.jLQ.setOnItemSelectedListener(new com.tencent.mm.picker.base.b.b() {
            /* class com.tencent.mm.picker.f.e.AnonymousClass2 */

            @Override // com.tencent.mm.picker.base.b.b
            public final void onItemSelected(int i2) {
                AppMethodBeat.i(175368);
                int i3 = i2 + e.this.startYear;
                int intValue = ((Integer) e.this.jLR.getAdapter().getItem(e.this.jLR.getCurrentItem())).intValue();
                e.this.jMe = i3;
                int currentItem = e.this.jLR.getCurrentItem();
                if (e.this.startYear == e.this.endYear) {
                    e.this.jLR.setAdapter(new c(e.this.jLW, e.this.jLX, new b(e.this.ctx)));
                    if (currentItem > e.this.jLR.getAdapter().getItemsCount() - 1) {
                        currentItem = e.this.jLR.getAdapter().getItemsCount() - 1;
                        e.this.jLR.setCurrentItem(currentItem);
                    }
                    int i4 = e.this.jLW + currentItem;
                    if (e.this.jLW == e.this.jLX) {
                        e.a(e.this, i3, i4, e.this.jLY, e.this.jLZ, e.this.jMi, e.this.jMj);
                    } else if (i4 == e.this.jLW) {
                        e.a(e.this, i3, i4, e.this.jLY, 31, e.this.jMi, e.this.jMj);
                    } else if (i4 == e.this.jLX) {
                        e.a(e.this, i3, i4, 1, e.this.jLZ, e.this.jMi, e.this.jMj);
                    } else {
                        e.a(e.this, i3, i4, 1, 31, e.this.jMi, e.this.jMj);
                    }
                } else if (i3 == e.this.startYear) {
                    e.this.jLR.setAdapter(new c(e.this.jLW, 12, new b(e.this.ctx)));
                    if (intValue <= e.this.jLW) {
                        e.this.jLR.setCurrentItem(0);
                    } else {
                        e.this.jLR.setCurrentItem(intValue - e.this.jLW);
                    }
                    if (intValue == e.this.jLW) {
                        e.a(e.this, i3, intValue, e.this.jLY, 31, e.this.jMi, e.this.jMj);
                    } else {
                        e.a(e.this, i3, intValue, 1, 31, e.this.jMi, e.this.jMj);
                    }
                } else if (i3 == e.this.endYear) {
                    e.this.jLR.setAdapter(new c(1, e.this.jLX, new b(e.this.ctx)));
                    if (currentItem > e.this.jLR.getAdapter().getItemsCount() - 1) {
                        currentItem = e.this.jLR.getAdapter().getItemsCount() - 1;
                        e.this.jLR.setCurrentItem(currentItem);
                    }
                    if (intValue >= e.this.jLX) {
                        e.this.jLR.setCurrentItem(e.this.jLX - 1);
                    } else {
                        e.this.jLR.setCurrentItem(intValue - 1);
                    }
                    int i5 = currentItem + 1;
                    if (i5 == e.this.jLX) {
                        e.a(e.this, i3, i5, 1, e.this.jLZ, e.this.jMi, e.this.jMj);
                    } else {
                        e.a(e.this, i3, i5, 1, 31, e.this.jMi, e.this.jMj);
                    }
                } else {
                    e.this.jLR.setAdapter(new c(1, 12, new b(e.this.ctx)));
                    e.this.jLR.setCurrentItem(intValue - 1);
                    e eVar = e.this;
                    e.a(eVar, i3, eVar.jLR.getCurrentItem() + 1, 1, 31, e.this.jMi, e.this.jMj);
                }
                if (e.this.jMf != null) {
                    e.this.jMf.bla();
                }
                AppMethodBeat.o(175368);
            }
        });
        eVar3.jLR.setOnItemSelectedListener(new com.tencent.mm.picker.base.b.b() {
            /* class com.tencent.mm.picker.f.e.AnonymousClass1 */

            @Override // com.tencent.mm.picker.base.b.b
            public final void onItemSelected(int i2) {
                AppMethodBeat.i(175367);
                int i3 = i2 + 1;
                if (e.this.startYear == e.this.endYear) {
                    int i4 = (e.this.jLW + i3) - 1;
                    if (e.this.jLW == e.this.jLX) {
                        e.a(e.this, e.this.jMe, i4, e.this.jLY, e.this.jLZ, e.this.jMi, e.this.jMj);
                    } else if (e.this.jLW == i4) {
                        e.a(e.this, e.this.jMe, i4, e.this.jLY, 31, e.this.jMi, e.this.jMj);
                    } else if (e.this.jLX == i4) {
                        e.a(e.this, e.this.jMe, i4, 1, e.this.jLZ, e.this.jMi, e.this.jMj);
                    } else {
                        e.a(e.this, e.this.jMe, i4, 1, 31, e.this.jMi, e.this.jMj);
                    }
                } else if (e.this.jMe == e.this.startYear) {
                    int i5 = (e.this.jLW + i3) - 1;
                    if (i5 == e.this.jLW) {
                        e.a(e.this, e.this.jMe, i5, e.this.jLY, 31, e.this.jMi, e.this.jMj);
                    } else {
                        e.a(e.this, e.this.jMe, i5, 1, 31, e.this.jMi, e.this.jMj);
                    }
                } else if (e.this.jMe != e.this.endYear) {
                    e.a(e.this, e.this.jMe, i3, 1, 31, e.this.jMi, e.this.jMj);
                } else if (i3 == e.this.jLX) {
                    e.a(e.this, e.this.jMe, e.this.jLR.getCurrentItem() + 1, 1, e.this.jLZ, e.this.jMi, e.this.jMj);
                } else {
                    e.a(e.this, e.this.jMe, e.this.jLR.getCurrentItem() + 1, 1, 31, e.this.jMi, e.this.jMj);
                }
                if (e.this.jMf != null) {
                    e.this.jMf.bla();
                }
                AppMethodBeat.o(175367);
            }
        });
        eVar3.b(eVar3.jLS);
        eVar3.b(eVar3.jLT);
        eVar3.b(eVar3.jLU);
        eVar3.b(eVar3.jLV);
        if (eVar3.jKX.length != 6) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("type[] length is not 6");
            AppMethodBeat.o(175354);
            throw illegalArgumentException;
        }
        e.aP(eVar3.bll());
        if (this.context.getResources().getConfiguration().locale.getLanguage().endsWith("zh")) {
            e eVar4 = this.jLJ;
            String str2 = this.jKP.jLb;
            String str3 = this.jKP.jLc;
            String str4 = this.jKP.jLd;
            String str5 = this.jKP.jLe;
            String str6 = this.jKP.jLf;
            String str7 = this.jKP.jLg;
            if (str2 != null) {
                eVar4.jLQ.setLabel(str2);
            } else {
                eVar4.jLQ.setLabel(eVar4.view.getContext().getString(R.string.fmz));
            }
            if (str3 != null) {
                eVar4.jLR.setLabel(str3);
            } else {
                eVar4.jLR.setLabel(eVar4.view.getContext().getString(R.string.fmw));
            }
            if (str4 != null) {
                eVar4.jLS.setLabel(str4);
            } else {
                eVar4.jLS.setLabel(eVar4.view.getContext().getString(R.string.fmt));
            }
            if (str5 != null) {
                eVar4.jLT.setLabel(str5);
            } else {
                eVar4.jLT.setLabel(eVar4.view.getContext().getString(R.string.fmu));
            }
            if (str6 != null) {
                eVar4.jLU.setLabel(str6);
            } else {
                eVar4.jLU.setLabel(eVar4.view.getContext().getString(R.string.fmv));
            }
            if (str7 != null) {
                eVar4.jLV.setLabel(str7);
            } else {
                eVar4.jLV.setLabel(eVar4.view.getContext().getString(R.string.fmx));
            }
        }
        gd(this.jKP.ox);
        this.jLJ.setDividerColor(this.jKP.jKu);
        this.jLJ.jLw = this.jKP.jLw;
        e eVar5 = this.jLJ;
        boolean z = this.jKP.jKV;
        eVar5.jLQ.setCyclic(z);
        eVar5.jLR.setCyclic(z);
        eVar5.jLS.setCyclic(z);
        eVar5.jLT.setCyclic(z);
        eVar5.jLU.setCyclic(z);
        eVar5.jLV.setCyclic(z);
        this.jLJ.jLu = this.jKP.jLu;
        e eVar6 = this.jLJ;
        boolean z2 = this.jKP.jKn;
        eVar6.jLS.jKn = z2;
        eVar6.jLR.jKn = z2;
        eVar6.jLQ.jKn = z2;
        eVar6.jLT.jKn = z2;
        eVar6.jLU.jKn = z2;
        eVar6.jLV.jKn = z2;
        AppMethodBeat.o(175354);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(175355);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/picker/view/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (((String) view.getTag()).equals("submit")) {
            blg();
        }
        dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/picker/view/TimePickerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175355);
    }

    public final void blg() {
        AppMethodBeat.i(175356);
        if (this.jKP.jKS != null) {
            try {
                this.jKP.jKS.a(e.dateFormat.parse(this.jLJ.getTime()));
                AppMethodBeat.o(175356);
                return;
            } catch (ParseException e2) {
                Log.printStack(6, this.TAG, e2);
            }
        }
        AppMethodBeat.o(175356);
    }

    public final View bli() {
        AppMethodBeat.i(175357);
        if (this.jLJ.view == null) {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.bi7, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.inp);
            ((ViewGroup) inflate).removeView(linearLayout);
            linearLayout.setBackgroundColor(-1);
            this.jLJ.view = linearLayout;
        }
        View view = this.jLJ.view;
        AppMethodBeat.o(175357);
        return view;
    }

    @Override // com.tencent.mm.picker.f.a
    public final boolean blf() {
        return this.jKP.jLv;
    }

    public final void setDividerHeight(float f2) {
        AppMethodBeat.i(175358);
        if (this.jLJ != null) {
            e eVar = this.jLJ;
            eVar.jLS.setDividerHeight(f2);
            eVar.jLT.setDividerHeight(f2);
            eVar.jLU.setDividerHeight(f2);
            eVar.jLQ.setDividerHeight(f2);
            eVar.jLR.setDividerHeight(f2);
            eVar.jLV.setDividerHeight(f2);
        }
        AppMethodBeat.o(175358);
    }

    public final void dE(int i2, int i3) {
        AppMethodBeat.i(175359);
        e eVar = this.jLJ;
        eVar.jLS.setPadding(0, i2, 0, i3);
        eVar.jLT.setPadding(0, i2, 0, i3);
        eVar.jLU.setPadding(0, i2, 0, i3);
        eVar.jLQ.setPadding(0, i2, 0, i3);
        eVar.jLR.setPadding(0, i2, 0, i3);
        eVar.jLV.setPadding(0, i2, 0, i3);
        AppMethodBeat.o(175359);
    }
}
