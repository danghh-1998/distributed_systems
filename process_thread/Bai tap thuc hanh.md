# Chương 3: Tiến trình và luồng 

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Tệp nào vừa xuất hiện trong thư mục ChatRoomApp? Nó được sử dụng để làm gì?

- Khi chạy lệnh `npm init` file __package.json__ được tạo ra, đây là file cấu hình của __npm__, cho biết khi chạy ứng dụng thì ta cần cài đặt các package nào, chạy lệnh nào để chạy app, ngoài ra còn cho biết thông tin ứng dụng, author...

## Câu 2

> Mở trình duyệt và gõ vào đó địa chỉ http://localhost:3000, bạn sẽnhận được thông điệp gì?

- Nhận được dòng chữ __Hello, world__ từ trang web.

## Câu 3

> Bạn hãy thử reload (Ctrl-R) lại trình duyệt. Bạn có nhìn thấy gì mới xuất hiện trên cửa sổ không? Nếu không có gì xuất hiện hết thì là vì sao?

- Không có gì mới xuất hiện trên trình duyệt vì ta mới chỉ tạo socket ở server mà chưa có kết nối nào từ client đến server.

## Câu 4

> Refresh trang localhost:3000, bạn nhìn thấy thông điệp nào?

- Khi load lại trang, trên server ta nhận được thông điệp __New user connected__

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_3/process_thread/images/new_user_connected.png)

## Câu 5

> Bây giờ bạn hãy thử gõ gì đó lên một tab. Cùng lúc đó, nhìn sang tab khác của người dùng khác, bạn thấy gì?

- Khi ta gõ lên một tab và nhìn sang tab của người khác ta thấy dòng chữ __user_2 is typing a message__

![](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_3/process_thread/images/typing.png)