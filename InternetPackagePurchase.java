import java.util.Scanner;

public class InternetPackagePurchase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("حجم بسته موردنظر (گیگابایت) را وارد کنید: ");
            double volume = scanner.nextDouble();

            System.out.print("موجودی کیف پول (تومان) را وارد کنید: ");
            double balance = scanner.nextDouble();

            // ۱. بررسی اعتبار اطلاعات واردشده
            if (volume <= 0 || balance < 0) {
                System.out.println("حجم بسته یا موجودی واردشده نامعتبر است.");
                return;
            }

            // ۲. محاسبه قیمت پایه (هر گیگابایت ۵۰۰۰ تومان)
            double pricePerGb = 5000;
            double totalPrice = volume * pricePerGb;

            // ۳. اعمال تخفیف ۱۵ درصدی در صورت خرید بیشتر از ۱۰ گیگابایت
            if (volume > 10) {
                totalPrice = totalPrice * 0.85; // ۸۵ درصد قیمت اصلی (یعنی ۱۵ درصد تخفیف)
            }

            // ۴. بررسی کافی بودن موجودی و نمایش پیام متناسب
            if (balance >= totalPrice) {
                double remainingBalance = balance - totalPrice;
                System.out.printf("خرید با موفقیت انجام شد و موجودی باقی‌مانده %.0f تومان است.%n", remainingBalance);
            } else {
                double deficit = totalPrice - balance;
                System.out.printf("موجودی کاربر کافی نیست و مبلغ کسری %.0f تومان است.%n", deficit);
            }

        } catch (Exception e) {
            // مدیریت خطای ورود مقادیر غیرعددی
            System.out.println("حجم بسته یا موجودی واردشده نامعتبر است.");
        } finally {
            scanner.close();
        }
    }
}
