var app = angular.module("booksApp", []);

app.controller("booksCtrl", function ($scope, $sce, $http) {
    $scope.books = [];
    $http.get('/getBooks').then(function (response) {
        $scope.books = response.data;
    });

    $scope.authorsNames = [];
    $http.get('/getAuthorsNames').then(function (response) {
        $scope.authorsNames = response.data;
    });

    $scope.editBook = function (book) {
        book.edit = !book.edit;
        if (!book.edit) {
            console.log(book);
            $http.post('/updateBook', JSON.stringify(book)).then(function (response) {
                book.id = response.data.id;
            })
        } else {
            $scope.selected = $scope.authorsNames[$scope.getAuthorNameIndex(book.authorName)];
        }
    };

    $scope.deleteBook = function (book) {
        var index = $scope.books.indexOf(book);
        if (index !== -1) {
            if (book.id !== -1) {
                $http.post('/deleteBook', book.id).then(function (response) {
                    $scope.books.splice(index, 1);
                    console.log(response);
                })
            } else {
                $scope.books.splice(index, 1);
            }
        }
    };

    $scope.addBook = function () {
        $scope.books.push({
            id: -1,
            name: '',
            genre: '',
            year: '',
            authorName: [],
            edit: true
        })
    };

    $scope.wrapAuthorName = function (authorName) {
        return $sce.trustAsHtml("<a href='/authors'> " + authorName + "</a>");
    };

    $scope.switchAuthor = function (authorName, book) {
        $scope.selected = $scope.authorsNames[$scope.getAuthorNameIndex(authorName)];
        book.authorName = authorName;
    };

    $scope.getAuthorNameIndex = function(authorFullName) {
        for (let i = 0; i < $scope.authorsNames.length; i++) {
            console.log('here ' + $scope.authorsNames[i].fullName + ' vs ' + authorFullName);
            if ($scope.authorsNames[i].fullName === authorFullName) {
                return i;
            }
        }
        return -1;
    }

});