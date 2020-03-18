# Chương 1: Tổng quan các hệ phân tán 

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Đường dẫn đến file html chữa nội dung mặc định của trang web các bạn vừa xem là gì?

- Đường dẫn đến file html: `/var/www/html/index.html`

## Câu 2

> Cổng mặc định của dịch vụ www là gì?

- Cổng mặc định là cổng 80

## Câu 3

> Hãy giải thích quyền mang số 755 là gì?

- Số 7 đầu tiên: User `root` có quyền đọc, ghi, thực thi các file trong thư mục
- Số 5 thứ hai: Các user thuộc group `root` có quyền đọc, thực thi các file trong thư mục
- Số 5 thứ ba: Các user còn lại có quyền đọc, thực thi các file trong thư mục

## Câu 4

> Bạn quan sát thấy nội dung gì sau khi gõ 2 địa chỉ trên? Giải thích

- Quan sát thấy nội dung trang web tương ứng
- Đối với `example.com`

![Example.com](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_1_md/introduction/images/example_com.png)

- Đối với `test.com`

![Test.com](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_1_md/introduction/images/test_com.png)

- Khi gõ địa chỉ `example.com` vào thanh địa chỉ, máy tính sẽ tìm địa chỉ IP của host trong file `/etc/hosts` trước khi tim trên DNS. Ta đã config host `example.com` ứng với địa chỉ IP `127.0.0.1` hay `localhost`. Trên máy local đã cài sẵn web server apache nên yêu cầu được chuyển đến cho apache xử lý. Trong file `example.com.conf` ta đã config `ServerName example.com` do đó trang web sẽ render ra file `index.html` nằm trong `DocumentRoot /var/www/example.com/public_html` (mặc định tìm file index.html)

## Câu 7

> Vai trò của phương thức run là gì? Khi nào thì nó được gọi?

- Phương thức `run()` có vai trò tạo server xử lý đa luồng
- Được gọi khi có một client mới tạo connection tới server