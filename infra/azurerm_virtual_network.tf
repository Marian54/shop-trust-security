resource "azurerm_virtual_network" "vmtf_vnet" {
  name                = "${var.prefix}-network"
  address_space       = ["10.0.0.0/16"]
  location            = var.resource_group_location
  resource_group_name =  azurerm_resource_group.rg-azure-tf.name
}
