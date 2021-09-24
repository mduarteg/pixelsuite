db.createUser(
    {
        user: "pixel",
        pwd: "pixel1234",
        roles: [
            {
                role: "readWrite",
                db: "px-products"
            }
        ]
    }
)