# Singleton

## Định nghĩa
pattern cho phép bạn đảm bảo là một class chỉ có một thực thể, 
đồng thời cung cấp điểm truy cập toàn cầu cho thực thể này.

## Vấn đề
Có 2 vấn đề:
1. Một bóng đèn duy nhất và mọi người muốn vào bật nó lên. 
Và mỗi lần gạt công tắc thì đèn sẽ chuyển từ off sang on và ngược lại. 
2. Mỗi người sẽ chỉ được chạm vào công tắc theo thứ tự.

## Giải pháp
1. Tạo một private constucture
2. Tạo một static instance và getInstance để trả về instance
3. Thực hiện việc ngăn chặn khởi tạo cùng lúc bằng việc đồng bộ
4. Kiểm trả instance đã khởi tạo hay chưa trước khi thực hiện việc khởi tạo để giảm lượng truy cập vào khối đồng bộ

## Nâng cao
Nếu không dùng synchronize thì sao?
1. Lúc này ta sẽ khởi tạo một inner class là một final
2. Thực hiện new ngay khi khai báo instance trong lớp inner này
3. vì là final nên instance sẽ chỉ khởi tạo và gán giá trị lần đầu
