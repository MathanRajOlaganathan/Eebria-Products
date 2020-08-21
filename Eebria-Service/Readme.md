# Build Reactive Rest APIs with Spring WebFlux

## Requirements

1. Java - 1.11

2. Maven - 3.x.x

3. Spring Boot - 2.3.X

## Steps to Setup

**1. Clone the application**

```bash
https://github.com/MathanRajOlaganathan/Eebria-Products.git
```

**2. Build and run the app using maven**

```bash
cd Eebria-Service
mvn package
java -jar target/eebria-service-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```
Alternatively, you can run the built  jar which is  placed under Eebria-Service directory -

```bash
java -jar target/eebria-service-1.0.0.jar
```

**3. Run the app using docker**

```bash
docker pull mathanpointer/eebria-service
docker run  -d -p 8080:8080 mathanpointer/eebria-service

```

The server will start at <http://localhost:8080>.

The swagger will start at <http://localhost:8080/swagger-ui/>.

## Exploring the Rest APIs

The application defines following REST APIs

```
1. GET /my-eebria/product - Get All Products 

2. GET /my-eebria/product?type=beer - Get  All Products  by type (type - beer  or cider)


3. GET ​/my-eebria​/product​/{range} - Retrieve a Product by range (range - cheaper or expensive)

3. GET ​/my-eebria​/product​/sort?OrderBy=name,price&direction=ASC - Retrieve all Products Ordered by name,price in ascending or descending direction ( sorting can be done by  name or price alone or both ascending and descending.  orderBy - name,price direction-ASC or DESC)

```
## API Screenshots

**1.Get ALL Produts**

<http://localhost:8080/my-eebria/product>.

![getAllProducts](https://github.com/MathanRajOlaganathan/Eebria-Products/blob/master/Eebria-Service/imgs/eebria-getProducts.jpg?raw=true)


**2.Get Produts by  Type**

<http://localhost:8080/my-eebria/product?type=cider>.

![getProductsByType](https://github.com/MathanRajOlaganathan/Eebria-Products/blob/master/Eebria-Service/imgs/eebria-type.jpg?raw=true)


**3.Get Produts by Range**

<http://localhost:8080/my-eebria/product/expensive>.

![getProductsByRange](https://github.com/MathanRajOlaganathan/Eebria-Products/blob/master/Eebria-Service/imgs/eebria-range.jpg?raw=true)


**4.Get Sorted Produts**

http://localhost:8080/my-eebria/product/sort?orderBy=name,price&direction=DESC

![getProductsBySort](https://github.com/MathanRajOlaganathan/Eebria-Products/blob/master/Eebria-Service/imgs/eebria-sort.jpg?raw=true)





