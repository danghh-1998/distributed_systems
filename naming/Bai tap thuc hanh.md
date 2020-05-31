# Chương 5: Định danh

> Họ và tên: Hoàng Hải Đăng
>
> MSSV: 20160982
>
> Mã lớp: 114605
>
> Mã học phần: IT4614

## Câu 1

> Giải thích ý nghĩa các trường trong thông điệp ARP trên

- __Hardware type__: Xác định kiểu bộ giao tiếp phần cứng cần thiết (với Ethernet là 1).
- __Protocol type__: Xác định kiểu giao thức cấp cao máy gửi sử đụng để giao tiếp (với giao thức IP là 0x0800).
- __Hardware address length__: Xác định độ dài vật lý theo đơn vị byte. Địa chỉ MAC nên giá trị của nó sẽ là 6.
- __Protocol address length__: Xác định độ dài địa chỉ logic được sử dụng ở tầng mạng (với IPv4 sẽ có giá trị là 4).
- __OP code__: Xác định loại bản tin mà máy gửi gửi đi:
  - 1: bản tin ARP request.
  - 2: bản tin ARP repply.
  - 3: bản tin RARP request.
  - 4: bản tin RARP repply.
- __Sender hardware address (SHA)__: Địa chỉ MAC của máy gửi.
- __Sender protocol address (SPA)__: Địa chỉ IP của máy gửi.
- __Target hardware address (TPA)__: Địa chỉ MAC của máy nhận.
- __Target protocol address (PTA)__: Địa chỉ IP của máy nhận.

## Câu 2

> Hãy	cho biết các thông tin sau trong cửa sổ bạn đang	quan sát
>
> - Destination MAC address
> - Opcode
> - Target MAC address

![Wireshark request](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_5/naming/images/wireshark_req.png)

- __Destination MAC address__: 28:7f:cf:fe:07:0e
- __Opcode__: 1
- __Target MAC address__: 00:00:00:00:00:00

## Câu 3

> Hãy cho biết các thông tin sau trong cửa sổ bạn đang quan	sát:
>
> - Opcode
> - Sender MAC address
> - Sender IP address
> - Target MAC address
> - Target IP address

![Wireshark response](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_5/naming/images/wireshark.png)

- __Opcode__: 2
- __Sender MAC address__: 08:00:27:ef:7f:71
- __Sender IP address__: 192.169.1.37
- __Target MAC address__: 28:7f:cf:fe:07:0e
- __Target IP address__: 192.168.1.68

## Câu 4

> Bạn	quan sát được	gì và rút ra được kết luận gì?

![Wireshark arp](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_5/naming/images/wireshark_arp.png)

- Quan sát thấy ngoài __gateway__ thì có thêm bản ghi với địa chỉ IP và địa chỉ MAC chính là địa chỉ đã gửi gói tin đến máy nhận hiển thị khi ta dùng __Wireshark__.
- Kết luận: Khi gói tin được gửi nhận thành công thì máy sẽ lưu lại địa chỉ MAC và địa chỉ IP của máy gửi gói tin.

## Câu 5

> Vai trò của block forwarders trong block options là gì?

- __Forwarder__ được sử dụng trong trường hợp máy __ns1__ không thể phân giair tên miền thì nó sẽ yêu cầu phân giải tên miền cho các DNS được liệt kê trong block forwarders xử lý. Trong trường hợp này là DNS google.

## Câu 6

> Giải thích yêu cầu tìm kiếm forward và reverse trong DNS là gì?

- __Forwward DNS__ dùng để tìm kiếm địa chỉ IP từ một domain name cho trước.
- __Reverse DNS__ dùng để tìm kiếm domain name từ một địa chỉ IP cho trước.

## Câu 7

> 2 tệp db.ds.soict.hust.com và db.192.168.1 dùng để làm gì?

- Tệp __db.ds.soict.hust.com__ dùng để cấu hính tên miền nào ứng với địa chỉ IP nào trong forward lookup.
- Tệp __db.192.168.1__ dùng để cấu hình địa chỉ IP nào ứng với tên miền nào trong reverse lookup.

## Câu 8

> Hãy giải thích 3 kiểu bản	 ghi của DNS: SOA, NS, và A.

- __SOA__: là một thành phần duy nhất tồn tại trong mỗi tập tin cơ sở dữ liệu DNS gồm những thông tin về zone transfer và những thông tin về domain trên DNS Server.
- __NS__: là 1 record cần thiết nằm trong zone. Mỗi name server cho zone sẽ sở hữu 1 NS record. Chứa địa chỉ IP của DNS Server và những thông tin về domain đó.
- __A__: sử dụng với mục đích phân giải Host ra một địa chỉ 32-bit IPv4.

## Câu 9

> Lệnh trên sẽ đưa ra kết quả gì? Giải thích!

- Lệnh trên đưa ra kết quả

![Named checkzone](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_5/naming/images/named_checkzone.png)

## Câu 10

> Bạn dùng lệnh nào để chắc chắn là bind9 đang chạy?

- Có thể dùng lệnh để kiểm tra bind9 đang chạy như sau: `sudo service bind9 status`.

## Câu 11

> Bạn nhận được kết	quả gì sau 2 lệnh ở trên? Hãy giải thích cơ chế hoạt động của nó

- Kết quả thu được

![nslookup](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_5/naming/images/nslookup.png)

- Giải thích: 
  - Khi gõ lệnh `nslookup host1` máy sẽ tìm trong file __/etc/resolv.conf__ các nameserver để phân giải tên miền. Trong file hiện có nameserver `192.168.1.37` nên máy sẽ gửi yêu cầu phân giải tên miền cho `192.168.1.37`(ns1).
  - Ở máy ns1, ta đã cấu hình `host1.ds.soict.hust.com. IN A 192.168.1.10` trong file `db.ds.soict.hust.com` do vậy ns1 sẽ trả về kết quả như trên hình cho máy host.

## Câu 12

> Bạn thu được nội dung gì sau khi gõ 2 lệnh trên? Giải thích.

- Kết quả thu được

![nslookup-reverse](https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_5/naming/images/nslookup-reverse.png)

- Giải thích:
  - Khi chạy lệnh `nslookup 192.168.1.10` máy sẽ tìm trong file __/etc/resolv.conf__ các nameserver để phân giải tên miền. Trong file hiện có nameserver `192.168.1.37` nên máy sẽ gửi yêu cầu phân giải tên miền cho `192.168.1.37`(ns1).
  - Ở máy ns1, ta cấu hình `10 IN PTR host1.ds.soict.hust.com. ; 192.168.1.10` trong file ` /etc/bind/zones/db.192.168.1` tức là trong mạng `192.168.1.0/24` thì `192.168.1.10` sẽ ứng với tên miền  `host1.ds.soict.hust.com`

## Câu 13

> Bây giờ giả sử bạn muốn thêm 1 host vào mạng của bạn, và bạn cũng  muốn thêm nó vào dịch vụ DNS. Chỉ ra lần lượt các bước mà bạn phải làm/cấu  hình.

- Giả sử ta cần add máy host vào zone `"ds.soict.hust.com` đã tạo ở trên

  - Trong file `db.ds.soict.hust.com` ta thêm  `<host_domain>.ds.soict.hust.com. IN A <IP_host>`
  - Trong file `db.192.168.1` ta thêm `<IP_host> IN PTR <domain_host>.ds.soict.hust.com. ; <IP_host>`
  - Restart lại bind9 `sudo service bind9 restart`
  - Ở máy host ta thêm `namserver <IP_ns> ` vào file __/etc/resolv.conf__.

You can define a route with name `forbidden` 

```js
{
    path: "/oops/403",
    name "forbidden"
}
```

For unauthorized user:

```js
{
    role: "guest",
    access: false,
    redirect: "forbidden"
}
```

`redirect` use route name only https://github.com/anthonygore/vue-router-user-roles/blob/902e5fb1b22c866745297485c763f0fc2d893009/src/RouteProtect.js#L23

I hope this can help you