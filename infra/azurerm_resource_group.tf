resource "azurerm_resource_group" "rg-azure-tf" {
  name = var.resource_group_name
  location = var.resource_group_location
}