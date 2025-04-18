/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

/**
 *
 * @author Nasya Kirana M
 */
public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	 public static int calculateTax(
            int monthlySalary,
            int otherMonthlyIncome,
            int numberOfMonthWorking,
            int deductible,
            boolean isMarried,
            int numberOfChildren
    ) {
        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }

        int grossIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;

        int ptkp = 54000000;
        if (isMarried) {
            ptkp += 4500000 + (numberOfChildren * 1500000);
        }

        int taxableIncome = grossIncome - deductible - ptkp;
        if (taxableIncome < 0) {
            return 0;
        }

        return (int) Math.round(0.05 * taxableIncome);
    }
}
