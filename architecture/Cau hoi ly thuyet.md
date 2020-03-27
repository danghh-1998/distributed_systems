# Chương 1: Tổng quan các hệ phân tán

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Trong mô hình kiến trúc phân tầng OSI của Mạng máy tính, hãy trình bày tóm tắt chức năng của từng tầng. 

|        Tầng        | Chức năng                                                    |
| :----------------: | :----------------------------------------------------------- |
|   Physical layer   | Đảm bảo các yêu cầu truyền/nhận các chuỗi bit qua các phương tiện vật lý. |
|  Data link layer   | Tạo/gỡ bỏ khung thông tin (Frames), kiểm soát luồng và kiểm soát lỗi. |
|   Network layer    | Thực hiện chọn đường và đảm bảo trao đổi thông tin trong liên mạng với công nghệ chuyển mạch thích hợp. |
|  Transport layer   | Vận chuyển thông tin giữa các máy chủ (End to End). Kiểm soát lỗi và luồng dữ liệu. |
|   Session layer    | Quản lý các cuộc liên lạc giữa các thực thể bằng cách thiết lập, duy  trì, đồng bộ hóa và hủy bỏ các phiên truyền thông giữa các ứng dụng. |
| Presentation layer | Chuyển đổi cú pháp dữ liệu để đáp ứng yêu cầu truyền thông của các ứng dụng. |
| Application layer  | Giao tiếp người dùng và môi trường mạng.                     |

> Lấy ví dụ cụ thể khi chúng ta thay đổi /cập nhật một tầng bất kỳ thì không ảnh hưởng đến hoạt động của các tầng khác.

- Ví dụ khi ta thay đổi giao thức IPv4 sang IPv6 ở tầng mạng thì các người dùng không cần thay đổi trình duyệt hoặc các giao thức trên tầng ứng dụng hoặc không cần thay đổi các thiết bị phần cứng.

## Câu 2

> Cho ví dụ và phân tích một mô hình kiến trúc thuê bao /xuất bản (publish /subscribe)

- Ví dụ chức năng thông báo có video mới của Youtube, khi một video được tải lên Youtube, thay vì Youtube gửi thông báo cho các subcriber thì thông tin có video upload sẽ được đưa vào một message chanel sau đó sẽ gửi đến các user đã đăng ký kênh trước đó.

![pub_sub_flow](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_2/architecture/images/pub_sub_flow.png)

