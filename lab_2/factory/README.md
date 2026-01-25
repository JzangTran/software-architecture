# Factory

## Ý định
Mong muốn tạo một interface để các đối tượng trong một superclass, 
nhưng cho phép lớp con thay đổi loại đối tượng sẽ tạo.

## Vấn đề
Trước đây để vận chuyển hàng, công ty chủ yếu sử dụng truck để vận chuyển. 
Nên mã đã số nằm ở truck. Bây giờ công ty mở rộng vận chuyển bằng ship. 
Hãy giúp công ty giải quyết vấn đề này.

## Giải pháp
1. Khởi tạo một interface Transport có phương thức deliver là abstract
2. Sau đó implement Transport cho các phương tiện mà công ty đang sử dụng gồm Truck và Ship
3. Override và thực hiện viết lại logic của deliver
4. Khi sử dụng lớp con sẽ là Truck hoặc Ship tùy vào việc khởi tạo

## Lưu ý
Khởi tạo bằng Transport transport = new Truck()/Ship() thay vì gọi lớp con. 
Lý do là để tuân thủ các nguyên tắc của OOP và đúng với ý định của factory

