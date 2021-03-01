# JPA Tips

**Set Default Value for a Column**
```
@Column(name="Price", columnDefinition="Decimal(10,2) default '100.00'")
OR
@Column(name="Price")
private long price = 3; 
```

**Set max for varchar**
```
    @Column(columnDefinition="nvarchar(max)")
    public String content;
```
