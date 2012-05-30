#Gaelyk Bootstrap Resources

Gaelyk Bootstrap Resources plugins add [Twitter Bootstrap](http://twitter.github.com/bootstrap/) 
resources to the Gaelyk application.

#Usage
```html
<!doctype html>
<html>
<head>
  <title>${twitterBootstrap.brand}</title>
  <link rel="stylesheet" type="text/css" href="$twitterBootstrap.css" />
  <link rel="stylesheet" type="text/css" href="$twitterBootstrap.responsive" />
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js">
  </script>
  <script type="text/javascript" src="$twitterBootstrap.js"></script>
  <style type="text/css">
      body {
          padding-top: <%=twitterBootstrap.gap%>px;
      }  
  </style>
</head>
<body>
    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="brand" href="/">${twitterBootstrap.brand}</a>
            </div>
        </div>
    </div>

    <div class="container">

    </div>
</body>
</html>
```
The plugin add `twitterBootstrap` variable into your templates and scripts. The variable contains following propeties

  * `css` - path to core CSS file
  * `js` - path to JavaScript addons
  * `responsive` - path to responsive CSS file
  * `logo` - path to your logo you want to show in the navbar
  * `brand` - brand to be shown in navbar
  * `gap` - top body margin used when navbar is present


#Customization

You can customize these properties application wide in `plugins.groovy` or in any other place 
where the application is initialized so you replace default bootstrap theme with your one. 
Use `TwitterBootstrap.configure{}` method for that purpose.

```groovy
TwitterBootstrap.configure {
    css = '/css/appsatori-bootstrap.0.1.5.css'
    gap = 100
    logo = '/img/ContactSatori-logo.png'
    brand = 'ContactSatori'
}
```

